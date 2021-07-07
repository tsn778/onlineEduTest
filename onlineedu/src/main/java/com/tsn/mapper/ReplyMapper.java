package com.tsn.mapper;

import com.tsn.pojo.Reply;
import com.tsn.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ReplyMapper {
    List<Reply> getReplys();

    Reply getReplyById(Integer id);
    Reply getReplyByAccount(String account);
    int addReply(Reply reply);
    int deleteReply(Integer id);
    int updateReply(Reply reply);
}
