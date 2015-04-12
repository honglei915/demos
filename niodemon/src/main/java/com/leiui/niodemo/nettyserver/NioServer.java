package com.leiui.niodemo.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NioServer {
    public final static String HOST = "192.168.1.112";
    //public final static String HOST = "127.0.0.1";

    public final static int PORT = 8083;

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap bt = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ChannelInitializer<Channel> childHandler = new ChannelInitializer<Channel>() {

            @Override
            public void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder());              
                ch.pipeline().addLast(new StringEncoder());
                ch.pipeline().addLast(new ServerHandler());
            }

        };
        bt.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).localAddress(PORT)
                .childHandler(childHandler).option(ChannelOption.SO_BACKLOG, 100);
        ChannelFuture f = bt.bind().sync();
        f.channel().closeFuture().sync();
    }

}
