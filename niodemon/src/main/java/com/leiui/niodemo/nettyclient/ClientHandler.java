package com.leiui.niodemo.nettyclient;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    ByteBuf mess = Unpooled.buffer(2048);

    // @Override
    // protected void channelRead(ChannelHandlerContext ctx, ByteBuf msg) throws
    // Exception {
    // System.out.println("channelRead:" + msg);
    // }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead:" + toString((ByteBuf) msg));
        ctx.writeAndFlush(toByte("haha"));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
        ctx.writeAndFlush(toByte("hello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahhahello serverhahahahaahhahahahahahahahahaahahahahhahahaahhahahaahhaahahahahahahahahahahahaahahahhahahahha"));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete");
        ctx.flush();
    }

    private ByteBuf toByte(String ms) {
        
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
}
