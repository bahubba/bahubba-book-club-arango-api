package com.bahubba.bahubbabookclub.exception;

/** Custom exception for when a membership request that doesn't exist */
public class MembershipRequestNotFoundException extends RuntimeException {
    /**
     * Generates exception for missing membership request by Reader and Book Club IDs
     *
     * @param username the username of the reader requesting membership
     * @param bookClubName the name of the book club the reader is requesting membership in
     */
    public MembershipRequestNotFoundException(String username, String bookClubName) {
        super("Could not find request for membership in '" + bookClubName + "' by '" + username + "'");
    }
}
