package com.back.boundedContext.member.eventListener;

import static org.springframework.transaction.annotation.Propagation.*;
import static org.springframework.transaction.event.TransactionPhase.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import com.back.boundedContext.member.entity.Member;
import com.back.boundedContext.member.service.MemberService;
import com.back.shared.post.event.PostCommentCreatedEvent;
import com.back.shared.post.event.PostCreatedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberEventListener {
	private final MemberService memberService;


	// 글 작성 시 점수 3점 올림
	@TransactionalEventListener(phase=AFTER_COMMIT)
	@Transactional(propagation = REQUIRES_NEW)
	public void handle(PostCreatedEvent event) {
		Member member = memberService.findById(event.getPost().getAuthorId()).get();

		member.increaseActivityScore(3);
	}

	// 댓글 작성 시 점수 1점 올림
	@TransactionalEventListener(phase = AFTER_COMMIT)
	@Transactional(propagation = REQUIRES_NEW)
	public void handle(PostCommentCreatedEvent event) {
		Member member = memberService.findById(event.getPostComment().getAuthorId()).get();

		member.increaseActivityScore(1);
	}
}
