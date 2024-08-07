package org.example.offer.come.nioListen;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class MyServer {
    private int size = 1024;
    private ServerSocketChannel serverSocketChannel;

    private ByteBuffer byteBuffer;

    private Selector selector;

    private int remoteClientNum = 0;

    public MyServer(int port) {
        try {
            initChannel(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initChannel(int port) throws IOException {
        //open channel
        serverSocketChannel = ServerSocketChannel.open();
        //set no blocking
        serverSocketChannel.configureBlocking(false);
        //bind port
        serverSocketChannel.bind(new InetSocketAddress(port));
        System.out.println("Linster on port: " + port);
        //create selector;
        selector = Selector.open();
        //bind channel
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        byteBuffer = ByteBuffer.allocate(size);
    }

    private void listener() throws Exception {
        while (true) {
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    //GET channel
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector, channel, SelectionKey.OP_ACCEPT);
                    remoteClientNum++;
                    System.out.println("online lcient num = " + remoteClientNum);
                    write(channel, "Hello client".getBytes());
                }
                if (selectionKey.isReadable()) {
                    read(selectionKey);
                }
                iterator.remove();
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        byteBuffer.clear();
        while ((count = socketChannel.read(byteBuffer)) > 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
        if (count < 0) {
            socketChannel.close();
        }
    }

    private void write(SocketChannel channel, byte[] writeData) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(writeData);
        byteBuffer.flip();
        channel.write(byteBuffer);
    }
    private void registerChannel(Selector selector, SocketChannel socketChannel, int opRead) throws IOException {
        if (socketChannel == null) {
            return;
        }
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, opRead);
    }

    public static void main(String[] args) {
        try {
            MyServer myServer = new MyServer(9999);
            myServer.listener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
