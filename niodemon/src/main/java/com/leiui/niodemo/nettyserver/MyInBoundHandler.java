package com.leiui.niodemo.nettyserver;

import io.netty.buffer.ChannelBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

public class MyInBoundHandler implements ChannelInboundHandler {

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void inboundBufferUpdated(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void beforeAdd(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void afterAdd(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void beforeRemove(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void afterRemove(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub

    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // TODO Auto-generated method stub

    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // TODO Auto-generated method stub

    }

    public ChannelBuf newInboundBuffer(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public void freeInboundBuffer(ChannelHandlerContext ctx, ChannelBuf buf) throws Exception {
        // TODO Auto-generated method stub

    }

}
