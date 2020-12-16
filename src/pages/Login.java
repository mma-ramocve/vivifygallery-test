package pages;

public class Login {
    public static String loginUrl = "https://gallery-app.vivifyideas.com/login";

    public static String loginEmailXPath = "//input[@id='email']";
    public static String loginPasswordXPath = "//input[@id='password']";

    public static String submitButtonXPath = "//button[contains(text(),'Submit')]";
    public static String myGalleriesTabXpath = "//a[contains(text(),'My Galleries')]";

    public static String createGalleryTabXPath = "//a[contains(text(),'Create Gallery')]";

    public static String newGalleryTitleXPath = "//input[@id='title']";
    public static String newGalleryDescriptionXPath = "//input[@id='description']";
    public static String newGalleryImagesUrlXPath = "//body/div[@id='app']/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]";
    public static String newGallerySubmitButtonXPath = "//button[contains(text(),'Submit')]";


}
