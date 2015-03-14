package com.leiui.niodemo.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NioServer {
    public final static String HOST = "192.168.1.112";

    public final static int PORT = 8083;

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap bt = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ChannelInitializer<Channel> childHandler = new ChannelInitializer<Channel>() {

            @Override
            public void initChannel(Channel ch) throws Exception {
                ChannelHandler handler = null;
                ch.pipeline().addFirst(handler);

            }

        };
        bt.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).localAddress(PORT)
                .childHandler(childHandler);
        ChannelFuture f = bt.bind().sync();
        f.channel().closeFuture().sync();

    }

}
