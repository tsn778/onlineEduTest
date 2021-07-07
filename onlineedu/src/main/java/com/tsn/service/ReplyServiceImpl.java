package com.tsn.service;

import com.tsn.mapper.ReplyMapper;
import com.tsn.pojo.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{
@Autowired
    ReplyMapper replyMapper;
    @Override
    public List<Reply> getReplys() {
        return replyMapper.getReplys();
    }

    @Override
    public Reply getReplyById(Integer id) {
        return replyMapper.getReplyById(id);
    }

    @Override
    public Reply getReplyByAccount(String account) {
        return replyMapper.getReplyByAccount(account);
    }

    @Override
    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    @Override
    public int deleteReply(Integer id) {
        return replyMapper.deleteReply(id);
    }

    @Override
    public int updateReply(Reply reply) {
        return replyMapper.updateReply(reply);
    }
}
