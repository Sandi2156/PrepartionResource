package amazon_locker;

import amazon_locker.user.User;

public class Repository {
    public String getOTP(String lockerId) {
        return "123";
    }

    public User getUserDetails(String userId) {
        return new User();
    }

    public boolean verifyOTP(String otp, String lockerId) {
        return true;
    }
}
