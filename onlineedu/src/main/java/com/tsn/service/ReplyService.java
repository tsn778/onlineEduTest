package com.tsn.service;

import com.tsn.pojo.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplys();

    Reply getReplyById(Integer id);
    Reply getReplyByAccount(String account);
    int addReply(Reply reply);
    int deleteReply(Integer id);
    int updateReply(Reply reply);
}
