package NIOSelector.simplenio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        SocketChannel channel=null;
        try {
            channel=SocketChannel.open();
            channel.connect(new InetSocketAddress("127.0.0.1", 8800));
            ByteBuffer writebuffer=ByteBuffer.allocate(1024);
            ByteBuffer readbuffer=ByteBuffer.allocate(1024);

            writebuffer.put("hello server".getBytes());
            writebuffer.flip();

            while (true){
                writebuffer.rewind();
                channel.write(writebuffer);
                readbuffer.clear();
                channel.read(readbuffer);
                System.out.println("client receive:"+new String(readbuffer.array()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (channel!=null){
                try{
                    channel.close();
                }catch (IOException e){
                }
            }
        }
    }
}
