package com.leiui.niodemo.nettyclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import com.leiui.niodemo.nettyserver.NioServer;

public class NioClient {    

    public void start() throws InterruptedException {
        Bootstrap bt = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();

        bt.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(NioServer.HOST, NioServer.PORT))
                .handler(new ChannelInitializer<Channel>() {

                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addFirst(new ClientHandler());
                    }
                });
        ChannelFuture f = bt.connect().sync();
        f.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new NioClient().start();
        }
    }

}
