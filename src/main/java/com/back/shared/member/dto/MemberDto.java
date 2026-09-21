package com.back.shared.member.dto;

import java.time.LocalDateTime;

import com.back.boundedContext.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberDto {
	private final int id;
	private final LocalDateTime createDate;
	private final LocalDateTime modifyDate;
	private final String username;
	private final String nickname;

	public MemberDto(Member member) {
		this(
			member.getId(),
			member.getCreateDate(),
			member.getModifyDate(),
			member.getUsername(),
			member.getNickname()
		);
	}
}
