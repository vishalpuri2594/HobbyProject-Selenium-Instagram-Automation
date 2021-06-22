import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//static String u = "deeep_thinkers"; static String p = "rofkjdne4838@$_#";
public class Main {

    //Follow button on private profile
    static String btn_f1 = "/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div/button";
    //<h2> text for private profile 'This account is private'
    static String text_p1 = "/html/body/div[1]/section/main/div/div/article/div[1]/div/h2";
    //Follow button for public profile
    static String btn_pub1 = "/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div/div/span/span[1]/button";
    //Following button for already following profiles
    static String btn_follwng = "/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div[2]/div/span/span[1]/button";

    static WebDriver wb = null;
    static WebDriverWait wait;
    //static String u = "avogadro_memes"; static String p = "wocvmeos#&$_40";
    //static String u = "allopathic_memes"; static String p = "ekcpacm$$_292";
    //static String u = "bindis.toss_international"; static String p = "16252728";
    static String u = "shivani_karrah"; static String p = "rofkjdne4838@$_#";
    //static String u = "thereviewstation_"; static String p = "26533297$";
    //static String u = "choco_n_chunks"; static String p = "Himanshi123";
    static int totallikes = 0;
    static int totalfollow = 0;
    static int totalcomments = 0;
    static int maxlikes = 650;
    static int maxfollow = 35;
    static int maxcomments = 30;
    static HashMap<Integer, String> hashm_likeusers = new HashMap<Integer, String>();
    static int hashm_interator = 1;
    static boolean isCommenting = false;

    public static void main(String[] args) throws IOException {
        login_insta();
        System.out.println(u);
        ArrayList<String> ig_tags_t = new ArrayList<String>(Arrays.asList("#fitgirl"));

        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#like","#bhfyp","#nature","#throwback","#love","#photooftheday","#fashion","#travelphotography","#tiktok","#art","#followforfollowback","#insta","#picoftheday","#memes","#indianphotography","#indiapictures","#instagood","#follow","#goodvibes","#Chhattisgarh","#kanpur","#jaipur","#fashion","#pune","#California","#Illinois","#Texas","#Arizona","#Pennsylvania","#Florida","#Ohio","#NorthCarolina","#Indiana","#Colorado","#DistrictofColumbia","#Massachusetts","#Tennessee","#Michigan","#Oklahoma","#Oregon","#Nevada","#Kentucky","#Maryland","#Wisconsin","#NewMexico","#Georgia","#Missouri","#Nebraska","#Virginia","#Minnesota","#Louisiana","#Kansas","#Hawaii"));
        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#California","#Illinois","#Texas","#Arizona","#Pennsylvania","#Florida","#Ohio","#Indiana","#Colorado","#Massachusetts","#Tennessee","#Michigan","#Oklahoma","#Oregon","#Nevada","#Kentucky","#Maryland","#Wisconsin","#NewMexico","#Georgia","#Missouri","#Nebraska","#Virginia","#Minnesota","#Louisiana","#Kansas","#Hawaii","#Alaska"));
        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#footballmemes","#footballfans","#football","#footballlove","#footballskills","#footballboots","#footballgame","#footballplayer","#messi","#manchesterunited","#mufc","#footballnews","#manutd","#messi","#ronaldo","#fplteams","#soccer","#soccerlife","#sports","#pogba","#soccerskills","#barcelona","#martial","#rashford","#bruno","#bhfyp","#nature","#throwback","#love","#photooftheday","#fashion","#travelphotography","#tiktok","#art"));
        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#corporategift","#gifthampers","#giftingideas","#giftset","#homemadechocolate","#assortedchocolates","#giftsforhim","#giftsforher","#mixchocolates","#indiangifts","#giftbox","#chocolategifts","#customisedchocolates","#giftboxideas","#Haryana","#Pune","#Kashmir","#Assam","#Orissa","#Gurugram","#Ghaziabad","#Raigarh","#Udaipur","#Gujrat","#Bangaluru","#Andaman","#Chennai","#DamanandDiu","#Daman","#Diu","#Delhi","#Panipat","#Rewari","#Rohtak","#Sirsa","#Sonipat"));

        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#memes","#funny","#lmfao","#dailymemes","#memesfortheday","#memepage","#dankmemes","#savage","#savagememes","#funnymeme","#edgymemes","#loveformemes","#memegirl","#memeart","#California","#Illinois","#Texas","#Arizona","#Pennsylvania","#Florida","#Ohio","#NorthCarolina","#Indiana","#Colorado","#DistrictofColumbia","#Massachusetts","#Tennessee","#Michigan"));
        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#Goa","#Gujarat","#Delhi","#Anand","#Banaskantha","#Bharuch","#Bhavnagar","#Dahod","#TheDangs","#Gandhinagar","#Ahmedabad","#Jamnagar","#Junagadh","#Kutch","#Kheda","#Mehsana","#Narmada","#Navsari","#Patan","#Panchmahal","#Porbandar","#Rajkot","#Sabarkantha","#Surendranagar","#Surat","#Vyara","#Vadodara","#Valsad","#Haryana","#Ambala","#Bhiwani","#Faridabad","#Fatehabad","#Gurgaon"));
        //ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#Patna","#Purnia","#Rohtas","#Saharsa","#Samastipur","#Saran","#Sheikhpura","#Sheohar","#Sitamarhi","#Siwan","#Supaul","#Vaishali","#WestChamparan","#Chandigarh","#Chhattisgarh","#Bastar","#Bijapur","#Bilaspur","#Dantewada","#Dhamtari","#Durg","#Jashpur","#JanjgirChampa","#Korba","#Koriya","#Kanker","#Kabirdham","#Mahasamund","#Narayanpur","#Raigarh"));
        ArrayList<String> ig_tags = new ArrayList<String>(Arrays.asList("#Haryana","#Pune","#Kashmir","#Orissa","#Gurugram","#Ghaziabad","#Bihar","#Hyderabad","#Gujrat","#Bengaluru","#Mumbai","#Chennai","#Delhi","#Panipat","#Jharkhand","#Rohtak","#Sirsa","#Sonipat","#YamunaNagar","#HimachalPradesh","#Bilaspur","#germany","#france"));

        // unfollow_from_excel("C:\\Users\\Vishal
        // Puri\\eclipse-workspace\\Instagram_data.xlsx", "four");

        //ArrayList<String> ig_tags, int loopCount, int capture_likes_perpost
        //targetted_marketing_likes(ig_tags_t, 7, 10);

        // ArrayList<String> ig_tags, String day,
        // int randomMaxFollow(min 4), int randomMaxLike(min 2),int randomMaxComment(min
        // 10), int loopCount
        follow_and_like_excel(ig_tags, "thirtyone", 10, 3, 20, 70);

        //user_profile_activities("twentynine");

    }

    @SuppressWarnings("resource")
    public static void readExcel(String filePath, String user_id, String f_or_uf, String day) throws IOException {

        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook wb = new XSSFWorkbook(inputStream);
        Sheet sheet = wb.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount + 1);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        String[] dataToWrite = { u, user_id, f_or_uf, strDate, day };
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = newRow.createCell(j);
            cell.setCellValue(dataToWrite[j]);
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(filePath);
        wb.write(outputStream);
        outputStream.close();

    }

    public static void targetted_marketing_likes(ArrayList<String> ig_tags, int loopCount, int capture_likes_perpost) {
        int count = ig_tags.size();
        for (int i = 0; i < count; i++) {
            if (i != 0) {
                WebElement close_image = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/button")));
                close_image.click();
            }

            WebElement search = wb.findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/input"));
            sleepFor(5000);
            search.sendKeys(ig_tags.get(i));
            System.out.print(" " + ig_tags.get(i) + " ");
            sleepFor(5000);
            search.sendKeys(Keys.ENTER);
            sleepFor(1000);
            search.sendKeys(Keys.ENTER);
            sleepFor(1000);
            search.sendKeys(Keys.ENTER);
            sleepFor(5000);

            try {
                WebElement first_image = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[1]/section/main/article/div[1]/div/div/div[1]/div[1]/a/div/div[2]")));
                first_image.click();
                sleepFor(5000);
            } catch (StaleElementReferenceException ex) {
                WebElement first_image = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("/html/body/div[1]/section/main/article/div[1]/div/div/div[1]/div[1]/a/div[1]/div[2]")));

                first_image.click();
                sleepFor(5000);
            }
            for (int j = 1; j <= loopCount; j++) {

                try {
                    WebElement next_button = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a")));
                    WebElement likecount_button;
                    try {
                        likecount_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("/html/body/div[4]/div[2]/div/article/div[3]/section[2]/div/div/button")));
                    } catch(NoSuchElementException ex) {
                        likecount_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("/html/body/div[4]/div[2]/div/article/div[3]/section[2]/div/div[2]/button")));
                    }
                    sleepFor(1000);
                    System.out.print(j + " ");
                    if (likecount_button.isDisplayed()) {
                        likecount_button.click();
                    }
                    sleepFor(1000);

                    WebElement likers_count;
                    try {
                        likers_count = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("/html/body/div[4]/div[2]/div/article/div[3]/section[2]/div/div/button/span")));
                    } catch(NoSuchElementException ex) {
                        likers_count = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("/html/body/div[4]/div[2]/div/article/div[3]/section[2]/div/div[2]/button/span")));
                    }
                    String temp_likecount = likers_count.getText();
                    temp_likecount = temp_likecount.replaceAll(",", "");

                    int likescount = Integer.parseInt(temp_likecount);
                    //System.out.print("like count is : " + likescount + " ");
                    // capture post like users in the global hashmap(max 100)
                    capture_liked_user(capture_likes_perpost);

                    sleepFor(10000);

                    WebElement likeclose_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("/html/body/div[6]/div/div/div[1]/div/div[2]/button")));
                    if (likeclose_button.isDisplayed()) {
                        likeclose_button.click();
                    }

                    if (j == 1 && next_button.isDisplayed()) {
                        next_button.click();
                        sleepFor(5000);
                    } else {
                        WebElement next_button2 = wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                        next_button2.click();
                    }

                } catch (NoSuchElementException ex) {
                    // System.out.println("" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                } catch (TimeoutException ex) {
                    // System.out.println("" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                } catch (StaleElementReferenceException ex) {
                    // System.out.println("" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                }
            }
        }
        WebElement close_image = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/button")));
        close_image.click();
    }

    public static void user_profile_activities(String day) {
        int l_total_f = 0;
        for (; hashm_interator <= hashm_likeusers.size(); hashm_interator++) {
            try {
                WebElement search = wb
                        .findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/input"));
                sleepFor(1000);
                search.sendKeys(hashm_likeusers.get(hashm_interator));
                System.out.print("" + hashm_likeusers.get(hashm_interator) + " ");
                sleepFor(4000);
                //System.out.println("check1");
                try {
                    search.sendKeys(Keys.ENTER);
                    sleepFor(1000);
                    search.sendKeys(Keys.ENTER);
                    sleepFor(1000);
                } catch (StaleElementReferenceException ex) {
                    //System.out.println("check2");
                }catch (ElementNotInteractableException ex) {
                    //System.out.println("check3");
                }

                String profile_type = "";
                sleepFor(4000);

                //System.out.println("check4");




                if (wb.findElements(By.xpath(btn_f1)).size() != 0
                        && wb.findElement(By.xpath(btn_f1)).getText().contentEquals("Follow")
                        && wb.findElements(By.xpath(text_p1)).size() != 0
                        && wb.findElement(By.xpath(text_p1)).getText().contentEquals("This Account is Private")) {
                    profile_type = "private";
                    if(totalfollow<=maxfollow) {wb.findElement(By.xpath(btn_f1)).click();
                        totalfollow++;
                        l_total_f++;
                        readExcel("C:\\Users\\Vishal Puri\\eclipse-workspace\\Instagram_data.xlsx", hashm_likeusers.get(hashm_interator),
                                "Follow", day);
                    }
                } else if (wb.findElements(By.xpath(btn_f1)).size() != 0
                        && wb.findElement(By.xpath(btn_f1)).getText().contentEquals("Requested")) {
                    profile_type = "requested";
                } else if (wb.findElements(By.xpath(btn_f1)).size() != 0 ||
                        wb.findElements(By.xpath(btn_pub1)).size() != 0) {
                    profile_type = "public";
                    //System.out.println("check5");
                    WebElement pfl_first_image = null;
                    sleepFor(4000);

                    try {
                        if (wb.findElements(By
                                .xpath("/html/body/div[1]/section/main/div/div[3]/article/div/div/div[1]/div[1]/a/div"))
                                .size() != 0) {
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[3]/article/div/div/div[1]/div[1]/a/div"));
                        } else if (wb.findElements(By.xpath(
                                "/html/body/div[1]/section/main/div/div[2]/article/div/div/div[1]/div[1]/a/div[1]"))
                                .size() != 0) {
                            //System.out.println("check2");
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[2]/article/div/div/div[1]/div[1]/a/div[1]"));
                        } else if (wb.findElements(By.xpath(
                                "/html/body/div[1]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]/a/div[1]"))
                                .size() != 0) {
                            //System.out.println("check3");
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]/a/div[1]"));
                        } else if (wb.findElements(By.xpath(
                                "/html/body/div[1]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]/a/div/"))
                                .size() != 0) {
                            //System.out.println("check4");
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[3]/article/div[1]/div/div[1]/div[1]/a/div/"));
                        } else if (wb.findElements(By.xpath(
                                "/html/body/div[1]/section/main/div/div[2]/article/div[1]/div/div[1]/div[1]/a/div"))
                                .size() != 0) {
                            //System.out.println("check5");
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[2]/article/div[1]/div/div[1]/div[1]/a/div"));
                        } else if (wb.findElements(By
                                .xpath("/html/body/div[1]/section/main/div/div[2]/article/div/div/div[1]/div[1]/a/div"))
                                .size() != 0) {
                            //System.out.println("check6");
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[2]/article/div/div/div[1]/div[1]/a/div"));
                        } else if (wb.findElements(By.xpath(
                                "/html/body/div[1]/section/main/div/div[2]/article/div[1]/div/div[1]/div[1]/a/div[1]"))
                                .size() != 0) {
                            //System.out.println("check7");
                            pfl_first_image = wb.findElement(By.xpath(
                                    "/html/body/div[1]/section/main/div/div[2]/article/div[1]/div/div[1]/div[1]/a/div[1]"));
                        }

                        //System.out.println("check6");
                    } catch (TimeoutException ex) {
                        System.out.println("Line 319 timeout "+ ex);
                    }
                    pfl_first_image.click();
                    //System.out.println("check8");
                    sleepFor(1000);
                    //System.out.println("check7");
                    WebElement next_button = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a")));
                    WebElement like_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("/html/body/div[5]/div[2]/div/article/div[3]/section[1]/span[1]/button")));
                    if(totallikes<=maxlikes) {
                        like_button.click();
                        sleepFor(1000);
                        totallikes++;
                    }
                    next_button.click();
                    sleepFor(1000);
                    WebElement like_button2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("/html/body/div[5]/div[2]/div/article/div[3]/section[1]/span[1]/button")));
                    if(totallikes<=maxlikes) {
                        like_button2.click();
                        sleepFor(1000);
                        totallikes++;
                    }
                    WebElement close_image = wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/button")));
                    close_image.click();
                    sleepFor(1000);
                    if(totalfollow<=maxfollow) {
                        try {
                            wb.findElement(By.xpath(btn_pub1)).click();
                        } catch (NoSuchElementException ex) {
                            wb.findElement(By.xpath(btn_f1)).click();
                        }
                        sleepFor(1000);
                        totalfollow++;
                        readExcel("C:\\Users\\Vishal Puri\\eclipse-workspace\\Instagram_data.xlsx", hashm_likeusers.get(hashm_interator),
                                "Follow", day);
                    }
                    l_total_f++;
                } else if (wb
                        .findElements(By.xpath(btn_follwng))

                        .size() != 0) {
                    profile_type = "following";
                }
                System.out.println(profile_type+","+totallikes+","+totalfollow+ "  ");
            } catch (NoSuchElementException ex) {
                //System.out.println("365" + ex);
            } catch (TimeoutException ex) {
                //System.out.println("367" + ex);
            } catch (StaleElementReferenceException ex) {
                //System.out.println("369" + ex);
            } catch (IOException e) {
                //System.out.println("371" + e);
            } catch (ElementClickInterceptedException ex) {
                //System.out.println("373" + ex);
            }
            //System.out.println("check10");
            if(l_total_f>=10) {
                break;
            }
        }
    }

    public static void capture_liked_user(int likescount) {
        int k = 0, x = 0;
        while (k < likescount) {
            try {
                x++;
                String xpath = "/html/body/div[6]/div/div/div[2]/div/div/div[" + x % 17
                        +                                                    "]/div[2]/div[1]/div/span/a";
                WebElement likers_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                if (!hashm_likeusers.containsValue(likers_name.getText()) && likers_name.isDisplayed()) {
                    k++;
                    int key = hashm_likeusers.size();
                    hashm_likeusers.put(++key, likers_name.getText());
                    //System.out.print("\"size=" + hashm_likeusers.size());
                    JavascriptExecutor executor = (JavascriptExecutor) wb;
                    executor.executeScript(
                            "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"end\", inline: \"nearest\"});",
                            wb.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div")));
                    sleepFor(1000);
                    executor.executeScript(
                            "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"end\", inline: \"nearest\"});",
                            wb.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div")));
                } else {
                    JavascriptExecutor executor = (JavascriptExecutor) wb;
                    executor.executeScript(
                            "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"end\", inline: \"nearest\"});",
                            wb.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div")));
                    sleepFor(1000);
                }
                JavascriptExecutor executor = (JavascriptExecutor) wb;
                executor.executeScript(
                        "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"end\", inline: \"nearest\"});",
                        wb.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div")));
                //System.out.print("nls" + k + "," + x + "\" ");
            } catch (TimeoutException ex) {
                System.out.print("ex_t" + k + " ");
                JavascriptExecutor executor = (JavascriptExecutor) wb;
                executor.executeScript(
                        "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"end\", inline: \"nearest\"});",
                        wb.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div")));
            } catch (StaleElementReferenceException ex) {
                System.out.print("ex_s" + k + " ");
                JavascriptExecutor executor = (JavascriptExecutor) wb;
                executor.executeScript(
                        "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"end\", inline: \"nearest\"});",
                        wb.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div")));
            }
        }

//		for (Map.Entry m : hashm_likeusers.entrySet()) {
//			System.out.println(m.getKey() + " " + m.getValue());
//		}
    }

    public static void follow_and_like_excel(ArrayList<String> ig_tags, String day, int randomMaxFollow,
                                             int randomMaxLike, int randomcomments, int loopCount) {
        int count = ig_tags.size();
        for (int i = 0; i < count; i++) {

            WebElement search = wb.findElement(By.xpath("/html/body/div[1]/div/div/section/nav/div[2]/div/div/div[2]/input"));
            sleepFor(5000);
            search.sendKeys(ig_tags.get(i));
            int randomNumLike = ThreadLocalRandom.current().nextInt(2, randomMaxLike + 1);
            int randomNumFollow = ThreadLocalRandom.current().nextInt(4, randomMaxFollow + 1);
            int randomNumComments = ThreadLocalRandom.current().nextInt(10, randomcomments + 1);
            System.out.print(" Random numbers(like,follow,comment): " + randomNumLike + "," + randomNumFollow + ","
                    + randomNumComments);
            System.out.print(" " + ig_tags.get(i) + " ");
            sleepFor(5000);
            try {
                search.sendKeys(Keys.ENTER);
                sleepFor(1000);
                search.sendKeys(Keys.ENTER);
                sleepFor(1000);
                search.sendKeys(Keys.ENTER);
                sleepFor(5000);
            } catch(StaleElementReferenceException ex) {
                //do nothing
            }


            try {
                WebElement first_image = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("/html/body/div[1]/div/div/section/main/article/div[1]/div/div/div[1]/div[1]/a/div/div[2]")));
                first_image.click();
                sleepFor(5000);
            } catch (StaleElementReferenceException ex) {
                WebElement first_image = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("/html/body/div[1]/div/div/section/main/article/div[1]/div/div/div[1]/div[1]/a/div[1]/div[2]")));

                first_image.click();
                sleepFor(5000);
            } catch (ElementClickInterceptedException ex) {
                WebElement first_image = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("/html/body/div[1]/section/main/article/div[1]/div/div/div[1]/div[1]/a/div[1]/div[2]")));

                first_image.click();
                sleepFor(5000);
            }
            for (int j = 1; j <= loopCount; j++) {

                try {
                    boolean if_follow = false;
                    sleepFor(5000);
//                    WebElement follow_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                            By.xpath("/html/body/div[4]/div[2]/div/article/header/div[2]/div[1]/div[2]/button")));
                    //sleepFor(1000);
                    WebElement like_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("/html/body/div[5]/div[2]/div/article/div[3]/section[1]/span[1]/button")));
                    WebElement next_button = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a")));
                    WebElement user_id = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("/html/body/div[5]/div[2]/div/article/header/div[2]/div[1]/div[1]/span/a")));
                    // sleepFor(10000);
//					if (follow_button.getText().contentEquals("Follow") && j % randomNumFollow == 0
//							&& totalfollow <= 60) {
//						try {
//						follow_button.click();
//						if_follow = true;
//						totalfollow++;
//						} catch (ElementClickInterceptedException ex) {
//							//System.out.println("" + ex);
//						}
//					}
                    System.out.print(j + " ");
                    // sleepFor(10000);
                    if (like_button.isDisplayed() && j % randomNumLike == 0 && totallikes<=maxlikes &&j>9) {
                        like_button.click();
                        totallikes++;
                    }
                    // sleepFor(5000);
                    if (j % randomNumComments == 0 && totalcomments<=maxcomments && isCommenting) {
                        post_comments();
                    }

                    if (if_follow) {
                        readExcel("C:\\Users\\Vishal Puri\\eclipse-workspace\\Instagram_data.xlsx", user_id.getText(),
                                "Follow", day);
                    }
                    //sleepFor(3000);

                    if (j == 1 && next_button.isDisplayed()) {
                        next_button.click();
                        sleepFor(5000);
                    } else {
                        WebElement next_button2 = wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                        next_button2.click();
                    }
                    // sleepFor(5000);

                } catch (NoSuchElementException ex) {
                    //System.out.println("" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                } catch (TimeoutException ex) {
                    //System.out.println("line 487" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                } catch (StaleElementReferenceException ex) {
                    //System.out.println("" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                } catch (IOException e) {
                    System.out.println("" + e);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                    e.printStackTrace();
                } catch (ElementClickInterceptedException ex) {
                    //System.out.println("" + ex);
                    WebElement next_button2 = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[1]/div/div/a[2]")));
                    next_button2.click();
                }
            }

            System.out.println("");
            System.out.println("Total actions(like,follow,comment):(" + totallikes + "," + totalfollow + ","
                    + totalcomments + ")");
            WebElement close_image = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/button")));
            close_image.click();

            if((i)%3==0) {
                user_profile_activities(day);
            }
        }
    }

    public static void sleepFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void post_comments() {
//		ArrayList<String> ig_comments = new ArrayList<String>(Arrays.asList(
//				"Check out my page ❤️",
//				"Enjoy at least one sunset per day! Check my page as well ❤️❤️", "Pretty cool ❤️ ❤️",
//				"Follow @themufcstand for regular fpl, football, transfer related updates, polls and some giveaways ♦️",
//				"❤️ ❤️ ❤️"));

        ArrayList<String> ig_comments = new ArrayList<String>(Arrays.asList(
//				"I just hit 500 followers, check out my content as well, it is as good as yours sweetheart ❤️",
//				"That's nice ❤️",
//				"I just hit 500 followers, check out my content as well ❤️",
//				"I just hit 500 followers, check out my content, it is as good as yours sweetheart ❤️❤️",
//				"I just hit 500 followers, check out my page, it is as good as yours sweetheart ❤️",
//				"I just hit 500 followers, check out my page as well, it is as good as yours sweetheart ❤️❤️",
//				"That's great ❤️, I just reached 500 followers, check out my page as well ❤️",
//				"That's great ❤️❤️, I just reached 500 followers, check out my page as well ❤️",
//				"That's awesome!! ❤️ ❤️, I just reached 500 followers, check out my page as well ❤️",
//				"You are the best! :) ❤️, I just reached 500 followers, check out my page as well ❤️",
//				"Wooww ❤️ ❤️ , I just reached 500 followers, check out my page as well ❤️",
                "Check out my page ❤️",
//				"Cool! Check my stories and memes ❤️, I just reached 500 followers, check out my page as well ❤️",
                "Would you choose the mountains or the beach? and why?", "Who’s your role model?",
                "Who inspires you every day?", "What’s the one thing you do for everyone?",
                "What’s the one book that you offer as a gift most?", "What’s the best compliment you ever gave?",
                "What’s one thing you can’t live without?", "What YouTube channel is great to binge?",
                "What year would you travel back in time and why?",
                "What would you tell the 21-year-old version of yourself?",
                "What was your dream job as a kid?", "What do you think about COVID-19?",
                "What do you love about your job?", "What are you most thankful for today?",
                "What are some good weird questions to ask someone to get to know them better?",
                "What are some common sense or unspoken rules, that you’ve seen people not follow?",
                "If authors ‘covered’ novels the way musicians cover songs",
                "which covered novel would you be most excited to read?",
                "What’s one thing you wish you learned earlier?",
                "What’s something no one would know about you by looking at your Instagram account?",
                "What motivates you the most?", "What pushed you to start your business/brand/account?",
                "What’s your ‘why’ behind what you’re doing/what drives you?",
                "Am I really attractive, or is my selfie game just strong?", "Will this matter a year from now?",
                "Are you a cat or a dog person?", "Do you have any questions for me?", "Thats amazing ❤️",
                "Today, I’m about 90% coffee and 10% dry shampoo. ❤️", "You can’t sip with us. ❤️",
                "Current mood: college life. ❤️",
                "We can save the world together ❤️", "I was an innocent being once…then my best friend came along. ❤️",
                "If you are funny, you are automatically 75% more probable that we are friends. You know, many things change and fade, but sarcasm is forever. ❤️",
                "If there would be an award for being lazy, I would send someone to pick it up for me. ❤️",
                "Enjoy at least one sunset per day! Check my page as well ❤️❤️", "Pretty cool ❤️ ❤️",
                "❤️ ❤️ ❤️"));
        int randomNumComments = ThreadLocalRandom.current().nextInt(0, ig_comments.size());
        System.out.print("\"RandomComments=" + randomNumComments + "\" ");
        WebElement comment_textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Ypffh")));
        comment_textbox.click();
        WebElement comment_textbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Ypffh")));
        sleepFor(1000);
        comment_textbox2.sendKeys(ig_comments.get(randomNumComments));
        WebElement comment_post_button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[5]/div[2]/div/article/div[3]/section[3]/div/form/button[2]")));
        comment_post_button.click();
        totalcomments++;
    }

    public static void unfollow_from_excel(String filePath, String day) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        @SuppressWarnings("resource")
        Workbook wrb = new XSSFWorkbook(inputStream);
        Sheet sheet = wrb.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        // for (int i = 1; i < 5; i++) {
        for (int i = 1; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(2).getStringCellValue().contentEquals("Follow")
                    && row.getCell(4).getStringCellValue().contentEquals(day)
                    && row.getCell(0).getStringCellValue().contentEquals(u)) {
                // wb.get("https://www.instagram.com/" + row.getCell(0).getStringCellValue());
                try {
                    WebElement search = wb
                            .findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[2]/input"));
                    sleepFor(3000);
                    search.sendKeys(row.getCell(1).getStringCellValue());
                    search.sendKeys(Keys.ENTER);
                    sleepFor(2000);
                    search.sendKeys(Keys.ENTER);
                    sleepFor(2000);
                    search.sendKeys(Keys.ENTER);
                    sleepFor(2000);

                    WebElement profile_deleted = wb.findElement(By.xpath("/html/body/div[1]/section/main/div/h2"));
                    if (profile_deleted.isDisplayed()) {
                        Cell cell = row.getCell(2);
                        cell.setCellValue("Deleted");
                        FileOutputStream outputStream = new FileOutputStream(filePath);
                        wrb.write(outputStream);
                        outputStream.close();
                        continue;
                    }
                } catch (NoSuchElementException ex) {

                } catch (StaleElementReferenceException ex) {
                    Cell cell = row.getCell(2);
                    cell.setCellValue("Unreachable");
                    FileOutputStream outputStream = new FileOutputStream(filePath);
                    wrb.write(outputStream);
                    outputStream.close();
                    continue;
                }

                try {
                    WebElement profile_deleted = wb.findElement(By.xpath("/html/body/div/div[1]/div/div/h2"));
                    if (profile_deleted.isDisplayed()) {
                        Cell cell = row.getCell(2);
                        cell.setCellValue("Deleted");
                        FileOutputStream outputStream = new FileOutputStream(filePath);
                        wrb.write(outputStream);
                        outputStream.close();
                        continue;
                    }
                } catch (NoSuchElementException ex) {

                }

                WebElement profile_follow_button = null;
                boolean is_following = true;
                try {
                    profile_follow_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                            "/html/body/div[1]/section/main/div/header/section/div[1]/div[1]/div/div[2]/div/span/span[1]/button")));
                    // /html/body/div[1]/section/main/div/header/section/div[1]/button
                } catch (TimeoutException ex) {
                    is_following = false;
                }
                if (profile_follow_button.isDisplayed() && is_following) {
                    profile_follow_button.click();
                    sleepFor(5000);
                    WebElement popup_unfollow_button = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[1]")));
                    popup_unfollow_button.click();
                    sleepFor(5000);
                }
                Cell cell = row.getCell(2);
                cell.setCellValue("Unfollowed");
                FileOutputStream outputStream = new FileOutputStream(filePath);
                wrb.write(outputStream);
                outputStream.close();
            }
        }
        inputStream.close();
    }

    @SuppressWarnings("deprecation")
    public static void login_insta() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments();
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver",
                "C:\\chromedriver.exe");
        wb = new ChromeDriver(capabilities);
        wb.manage().window().maximize();
        wait = new WebDriverWait(wb, 10);
        wb.get("https://www.instagram.com");
        sleepFor(7000);
        WebElement username = wb.findElement(
                By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[1]/div/label/input"));
        username.sendKeys(u);
        WebElement password = wb.findElement(
                By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[2]/div/label/input"));
        password.sendKeys(p);
        WebElement login = wb.findElement(
                By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]"));
        login.click();
        sleepFor(3000);
        WebElement logInPopUp = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/section/main/div/div/div")));
        if (logInPopUp.isDisplayed()) {
            WebElement logInPopUp_notNow = wb
                    .findElement(By.xpath(
                            "/html/body/div[1]/div/div/section/main/div/div/div/div/button"));
            logInPopUp_notNow.click();
        }
        WebElement notificationsPopUp = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div")));
        if (notificationsPopUp.isDisplayed()) {
            WebElement notificationsPopUp_notNow = wb
                    .findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/button[2]"));
            notificationsPopUp_notNow.click();
        }
    }

}