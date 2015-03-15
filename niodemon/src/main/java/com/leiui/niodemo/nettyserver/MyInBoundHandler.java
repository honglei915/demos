package com.leiui.niodemo.nettyserver;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyInBoundHandler extends ChannelInboundHandlerAdapter {
    ByteBuf mess = Unpooled.buffer(2048);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead:" + ctx.channel().remoteAddress() + "," + toString((ByteBuf) msg));
        ctx.writeAndFlush(toByte("hello," + ctx.channel().remoteAddress()));
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered:" + ctx.channel().remoteAddress());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive:" + ctx.channel().remoteAddress());
    }

    private ByteBuf toByte(String ms) {
        mess.clear();
        try {
            mess.writeBytes(ms.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mess;
    }

   
    private String toString(ByteBuf bf) {
        try {
            byte[] bt = new byte[bf.readableBytes()];
            bf.readBytes(bt);
            return new String(bt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
