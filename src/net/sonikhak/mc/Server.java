package net.sonikhak.mc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;

import static java.lang.System.*;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public class Server implements Runnable {
    private ServerSocketChannel socketChannel;
    private Selector selector;

    private void accept() throws IOException {
        SocketChannel socket;
        for(int i = 0; i < 15; i++) {   //to prevent attacks.
            socket = socketChannel.accept();
            if(socket == null) {
                break;
            }
            socket.configureBlocking(false);
            socket.register(selector, SelectionKey.OP_READ);
            out.printf("Accepted connection %s", socket.socket().getInetAddress().getHostName());
        }
    }

    private void cycle() {
        try {
            selector.selectNow();
            for(SelectionKey skey : selector.selectedKeys()) {
                if(skey.isAcceptable()) {
                    accept();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({"InfiniteLoopStatement"})
    @Override
    public void run() {
        try {
            final int port = 25565;
            socketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            socketChannel.configureBlocking(false);
            socketChannel.socket().bind(new InetSocketAddress(port));
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            out.printf("Listening on port %d", port);
            while (true) {
                cycle();
            }
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }
}
