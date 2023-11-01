package week2;

public class Membership {
    private int membershipId;
    private String type;
    private double fee;
    private int feeDuration;
    private boolean isAutoRenewal;
    private String conditions;

    public Membership(int membershipId, String type, double fee, int feeDuration, boolean isAutoRenewal, String conditions) {
        this.membershipId = membershipId;
        this.type = type;
        this.fee = fee;
        this.feeDuration = feeDuration;
        this.isAutoRenewal = isAutoRenewal;
        this.conditions = conditions;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getFeeDuration() {
        return feeDuration;
    }

    public void setFeeDuration(int feeDuration) {
        this.feeDuration = feeDuration;
    }

    public boolean isAutoRenewal() {
        return isAutoRenewal;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        isAutoRenewal = autoRenewal;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipId=" + membershipId +
                ", type='" + type + '\'' +
                ", fee=" + fee +
                ", feeDuration=" + feeDuration +
                ", isAutoRenewal=" + isAutoRenewal +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}
