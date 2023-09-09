package com.bahubba.bahubbabookclub.controller;

import com.bahubba.bahubbabookclub.model.dto.MembershipRequestDTO;
import com.bahubba.bahubbabookclub.model.payload.MembershipRequestAction;
import com.bahubba.bahubbabookclub.model.payload.NewMembershipRequest;
import com.bahubba.bahubbabookclub.service.MembershipRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class MembershipRequestControllerTest {
    @Autowired
    MembershipRequestController membershipRequestController;

    @MockBean
    MembershipRequestService membershipRequestService;

    @Test
    void testRequestMembership() {
        when(membershipRequestService.requestMembership(any(NewMembershipRequest.class))).thenReturn(new MembershipRequestDTO());
        ResponseEntity<MembershipRequestDTO> rsp = membershipRequestController.requestMembership(new NewMembershipRequest());
        verify(membershipRequestService, times(1)).requestMembership(any(NewMembershipRequest.class));
        assertThat(rsp).isNotNull();
    }

    @Test
    void testHasPendingRequest() {
        when(membershipRequestService.hasPendingRequest(anyString())).thenReturn(true);
        ResponseEntity<Boolean> rsp = membershipRequestController.hasPendingRequest("foo");
        verify(membershipRequestService, times(1)).hasPendingRequest(anyString());
        assertThat(rsp).isNotNull();
    }

    @Test
    void testGetMembershipRequestsForBookClub() {
        when(membershipRequestService.getMembershipRequestsForBookClub(anyString())).thenReturn(List.of(new MembershipRequestDTO()));

        ResponseEntity<List<MembershipRequestDTO>> rsp = membershipRequestController.getMembershipRequestsForBookClub("foo");

        verify(membershipRequestService, times(1)).getMembershipRequestsForBookClub(anyString());
        assertThat(rsp).isNotNull();
    }

    @Test
    void testReviewMembershipRequest() {
        when(membershipRequestService.reviewMembershipRequest(any(MembershipRequestAction.class))).thenReturn(new MembershipRequestDTO());

        ResponseEntity<MembershipRequestDTO> rsp = membershipRequestController.reviewMembershipRequest(
            MembershipRequestAction.builder().build()
        );

        verify(membershipRequestService, times(1)).reviewMembershipRequest(any());
        assertThat(rsp).isNotNull();
    }
}
