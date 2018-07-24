package bkm.locator.model;

public class ElementModel {

    private OnBoardingActivity onBoardingActivity;
    private GetStartedActivity getStartedActivity;

    public OnBoardingActivity getOnBoardingActivity() {
        return onBoardingActivity;
    }

    public void setOnBoardingActivity(OnBoardingActivity onBoardingActivity) {
        this.onBoardingActivity = onBoardingActivity;
    }

    public GetStartedActivity getGetStartedActivity() {
        return getStartedActivity;
    }

    public void setGetStartedActivity(GetStartedActivity getStartedActivity) {
        this.getStartedActivity = getStartedActivity;
    }
}