package com.back.boundedContext.payout.app;

import org.springframework.stereotype.Service;

import com.back.shared.market.dto.OrderDto;
import com.back.shared.payout.dto.PayoutMemberDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayoutAddPayoutCandidateItemsUseCase {
	public void  addPayoutCandidateItems(OrderDto order) {
		log.debug("addPayoutCandidateItems.order: {}", order.getId());
	}
}
