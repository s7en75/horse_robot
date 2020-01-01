/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Elements;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author mohsen
 */
public class Horse {

    public static Map<String, String> cookies;
    static int j = 0;
    static int jj = 0;
    static int index = 0;
    public static boolean flag = false;
    public static boolean mahmooleFlag = false;
    static String caption;
    static String originalName;
    static String image;
    static String s;
    public static ArrayList<String> clear = new ArrayList<String>();
    public static ArrayList<String> flex = new ArrayList<String>();
    public static ArrayList<String> dual = new ArrayList<String>();
    public static ArrayList<String> UccList = new ArrayList<String>();
    public static ArrayList<String> FnsList = new ArrayList<String>();
    public static ArrayList<String> FagList = new ArrayList<String>();
    public static ArrayList<String> LensList = new ArrayList<String>();
    public static Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
    public static String simpleGlass;
    public static String flexible;
    public static String lens;
    public static String others;
    public static String full;
    public static String tablet;
    public static String kheshab;
    public static String kif;
    public static String shishe;
    public static JSONObject simpleJson;
    public static JSONObject flexJson;
    public static Elements ucc;
    public static Elements tablets;
    public static Elements watches;
    public static Elements fsn;
    public static Elements adhensive;
    public static Elements other;
    public static Elements cgs;
    public static Elements utf;
    public static Elements sch;
    public static String tag;
    public static int simplecount = 0;
    public static int fullcount = 0;
    public static int nanocount = 0;
    public static int lenscount = 0;
    public static int othercount = 0;
    public static int kifcount = 0;
    public static int cgscount = 0;
    public static int shishecount = 0;
    public static int kheshabcount = 0;
    public static int tabcount = 0;

    public static String mahmoole = "1565591";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        simpleGlass = new String("{\"simple\":[\n");
        flexible = new String("\"flex\":[\n");
        lens = new String("\"lens\":[\n");
        others = new String("\"others\":[\n");
        full = new String("\"full\":[\n");
        tag = new String();
        tablet = new String("\"tablet\":[\n");
        kheshab = new String("\"kheshab\":[\n");
        kif = new String("\"covers\":[\n");
        shishe = new String("\"shishe\":[\n");

        boolean spliter = false;
        simpleJson = new JSONObject();
        flexJson = new JSONObject();
        ucc = new Elements();
        fsn = new Elements();
        adhensive = new Elements();
        watches = new Elements();
        tablets = new Elements();
        other = new Elements();
        cgs = new Elements();
        utf = new Elements();
        sch = new Elements();

        Connection.Response response = Jsoup.connect("https://seller.digikala.com/account/login/")
                .method(Connection.Method.POST)
                .data("login[email]", "nevermore.inviss@gmail.com")
                .data("login[password]", "$##$697175$##$Mms")
                .data("returnUrl", "0")
                .execute();
        cookies = response.cookies();

        Document doc = Jsoup.connect("https://seller.digikala.com/packages/")
                .cookies(cookies)
                .data("items", "20")
                .data("sortColumn", "product_id")
                .data("sortOrder", "desc")
                .post();
        Elements link = doc.getElementsByTag("tr");
        for (Element element : link) {
            if (mahmooleFlag == false) {
                mahmooleFlag = true;
                continue;
            } else {
                String s = element.select(".c-ui-table__link").attr("href");
                mahmoole = s.substring(s.lastIndexOf("=") + 1);
                break;
            }
        }
        for (int i = 0; i < 100; i++) {
            // inja bayad shomare mahmoolaro jaye moteghayere mahmoole jagozari konid dakhel   
            Document data = Jsoup.connect("https://seller.digikala.com/package/sellerpackagedetail/?packageId=" + mahmoole)
                    .cookies(cookies)
                    .data("items", "100")
                    .data("page", String.valueOf(i))
                    .data("sortColumn", "product_id")
                    .data("sortOrder", "desc")
                    .maxBodySize(0)
                    .timeout(1000 * 5)
                    .post();
            Elements els = data.getElementsByClass("c-ui-table__row c-ui-table__row--collapsable c-ui-table__row--body");
            System.out.println("elllllsssss" + els);
            if (els.size() < 1) {
//                    System.out.println("breaked");
                break;
            }
            for (Element el : els) {

                try {
//                    System.out.println("hereeeee     " + el.select(".c-ui-table__cell").get(3).text());
                    if (spliter == false) {
                        tag = el.select(".c-ui-table__cell").get(3).text();
//                        System.out.println("im splitter      " + tag + "      " + el.select(".c-ui-table__cell").get(3).text());
                        spliter = true;
                    }
                    System.out.println("in seond step braek             " + tag + "             " + el.select(".c-ui-table__cell").get(3).text());
                    if ((tag.contains(el.select(".c-ui-table__cell").get(3).text())) && flag == true) {
//                        System.out.println("in seond step braek                  " + tag + "        " + el.select(".c-ui-table__cell").get(3));
//                        System.out.println(tag);
                        break;
                    }
                    System.out.println("in if first step                " + tag + "          " + el.select(".c-ui-table__cell").get(3).text());
                    if ((tag.contains(el.select(".c-ui-table__cell").get(3).text())) && flag == false) {
//                        System.out.println("in if first step                     " + tag + "       " + el.select(".c-ui-table__cell").get(3).text());
//                        System.out.println(tag);
                        flag = true;
                    }

//                    System.out.print(el.select(".table-word-wrap").get(0).text()+"   ");
//                    System.out.print(el.select(".table-word-wrap").get(5).text()+"   ");
//                    System.out.println(el.select(".table-word-wrap").get(7).text());
//                    s = el.select(".table-word-wrap > img").toString();
                    String count2 = convertToEnglishDigits(el.select(".c-ui-table__cell").get(6).text());
                    System.out.println("count                      " + count2);
                    caption = el.select(".c-ui-table__cell").get(1).text();
                    originalName = el.select(".c-ui-table__cell").get(1).text();
                    System.out.println("code    =  " + el.select(".c-ui-table__cell").get(3).text());
//                    System.out.println(originalName);

//                    System.out.println(count);
                    if (originalName.contains("6D") || originalName.contains("5D") || originalName.contains("FAG") || originalName.contains("مجموعه 3عددی ") || originalName.contains("DAG") || originalName.contains("DCC") || originalName.contains("4D") || originalName.contains("مجموعه سه عددی") || originalName.contains("ABLS")) {
                        if (!originalName.contains("SSP")) {
                            if (!originalName.contains("حریم")) {
                                if (!originalName.contains("Shadow")) {

                                    int pack = convertToNumber(originalName);
                                    int finalCount = pack * Integer.parseInt(count2);
                                    fullcount = finalCount + fullcount;
                                    caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                                    caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                                    caption = caption.replace("\\|", "");
                                    caption = caption.replace("دوربین", "");
                                    caption = caption.replace("محافظ", "");
                                    caption = caption.replace("صفحه", "");
                                    caption = caption.replace("نمایش", "");
                                    caption = caption.replace("پک", "");
                                    caption = caption.replace("مجموعه", "");
                                    caption = caption.replace("موبایل", "");
                                    caption = caption.replace("ال جی", "");
                                    caption = caption.replace("سامسونگ", "");
                                    caption = caption.replace("هوآوی", "");
                                    caption = caption.replace("هواوی", "");
                                    caption = caption.replace("ایسوس", "");
                                    caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                                    caption = caption.replace("شیائومی", "");
                                    caption = caption.replace("مدل", "");
                                    caption = caption.replace("عددی", "");
                                    caption = caption.replace("دو", "");
                                    caption = caption.replace("سه", "");
                                    caption = caption.replace("تک", "");
                                    caption = caption.replace("بی رنگ شفاف", "");
                                    caption = caption.replace("|", "");
                                    caption = caption.replace("سونی", "");
                                    caption = caption.replace("موبایل", "");
                                    caption = caption.replace("گلس", "");
                                    caption = caption.replace("مناسب", "");
                                    caption = caption.replace("برای", "");
                                    caption = caption.replace("گوشی", "");
                                    caption = caption.replace("هورس", "");
                                    caption = caption.replace("لنز", "");
                                    caption = caption.replace("بلک بری", "");
                                    caption = caption.replace("حرارت", "");
                                    caption = caption.replace("دیده", "");
                                    caption = caption.replace("شیشه ای", "");
                                    caption = caption.replace("بسته", "");
                                    caption = caption.replace("تمام چسب", "");
                                    caption = caption.replace("اپل", "");
                                    caption = caption.replace("لنز", "");
                                    caption = caption.replace("Horse", "");
                                    caption = caption.replace("Full", "");
                                    caption = caption.replace("Privacy", "");
                                    caption = caption.replace("FAG", "");
                                    caption = caption.replace("حریم شخصی", "");
                                    caption = caption.replace("ساعت", "");
                                    caption = caption.replace("هوشمند", "");
                                    caption = caption.replace("Ultra Clear Crystal", "");
                                    caption = caption.replace("نانو", "");
                                    caption = caption.replace(" و ", "");
                                    caption = caption.replace("تمام", "");
                                    caption = caption.replace("کاور", "");
                                    caption = caption.replace("گلکسی", "");
                                    caption = caption.replace("360", "");
                                    caption = caption.replace("3D", "");
                                    caption = caption.replace("درجه", "");
                                    caption = caption.replace("به همراه", "");
                                    caption = caption.replace("رنگی", "");
                                    caption = caption.replace("مجموعه", "");
                                    caption = caption.replace("دو", "");
                                    caption = caption.replace("عددی", "");
                                    caption = caption.replace("سه", "");
                                    caption = caption.replace("رنگی", "");
                                    caption = caption.replace("9H", "");
                                    caption = caption.replace("تمپرد", "");
                                    caption = caption.replace("Protection", "");
                                    FagList.add(caption);
                                    full = full + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                                    caption = originalName;
                                }
                            }
                        }
                    }

                    if ((!originalName.contains("تبلت")) && (originalName.contains("UCC") || originalName.contains("Milanese") || originalName.contains("محافظ صفحه نمایش و پشت") || originalName.contains("STL") || originalName.contains("سیلیکونی") || originalName.contains("سیلیکنی") || originalName.contains("Ultra Clear Crystal") || originalName.contains("مجموعه سه عددی") || originalName.contains("FPGKK") || originalName.contains("FPGK") || originalName.contains("CRH") || originalName.contains("ABLS") || originalName.contains("شیشه ای") || (originalName.contains("مجموعه دو عددی") && !originalName.contains("نانو")) || (originalName.contains("محافظ صفحه نمایش و پشت") && !originalName.contains("FSN")))) {
                        if (originalName.contains("محافظ صفحه نمایش و پشت")) {
                            caption = caption.replace("محافظ صفحه نمایش و پشت", "پشت ورو");
                        }

                        if (originalName.contains("FPGKK")) {
                            caption = caption.replace("FPGKK", "");
                            caption = caption.replace("مشکی", "");
                            caption = caption.replace("قرمز", "");
                            caption = caption.replace("آبی", "");
                            caption = caption.replace("ابی", "");
                        }
                        if (originalName.contains("FAG")) {
                            caption = caption.replace("مشکی", "");
                            caption = caption.replace("FAG", "");
                            caption = caption.replace("سفید", "");
                        }
                        System.out.println("simple           " + originalName);
                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
                        simplecount = finalCount + simplecount;
//                        clear.add(caption + "   " + finalCount);
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("5D", "");
                        caption = caption.replace("dual", "");
                        caption = caption.replace("6D", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("Privacy", "");
                        caption = caption.replace("حریم شخصی", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace(" و ", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("کاور", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("3D", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace("UCC", "");
                        UccList.add(caption);
                        System.out.println("adddeddd                      " + caption + "   " + finalCount);
                        simpleGlass = simpleGlass + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;
                    }

                    System.out.println("Original name before if " + originalName);
                    if ((originalName.contains("تبلت")) && (originalName.contains("UCC") || originalName.contains("Ultra Clear Crystal") || originalName.contains("مجموعه سه عددی") || originalName.contains("شیشه ای") || (originalName.contains("مجموعه دو عددی") && !originalName.contains("نانو")))) {
                        System.out.println("Original name after if           " + originalName);
                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
                        tabcount = finalCount + tabcount;
//                        clear.add(caption + "   " + finalCount);
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("تبلت", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("5D", "");
                        caption = caption.replace("dual", "");
                        caption = caption.replace("6D", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("Privacy", "");
                        caption = caption.replace("حریم شخصی", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace(" و ", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("کاور", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("3D", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace("UCC", "");
                        tablet = tablet + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;

                    }
                    if (originalName.contains("SCH")) {

                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
//                        clear.add(caption + "   " + finalCount);
                        kheshabcount = kheshabcount + finalCount;
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("خشاب", "");
                        caption = caption.replace("سیمکارت ", "");
                        caption = caption.replace("سیم کارت ", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("تبلت", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("5D", "");
                        caption = caption.replace("dual", "");
                        caption = caption.replace("6D", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("Privacy", "");
                        caption = caption.replace("حریم شخصی", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace(" و ", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("کاور", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("3D", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace("UCC", "");
                        kheshab = kheshab + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;

                    }

                    if (originalName.contains("لنز")) {
                        if (!originalName.contains("CGS") || originalName.contains("CMZ")) {
                            int pack = convertToNumber(caption);
                            int finalCount = pack * Integer.parseInt(count2);
                            lenscount = finalCount + lenscount;
//                        flex.add(caption + "   " + finalCount);
                            caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                            caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                            caption = caption.replace("\\|", "");
                            caption = caption.replace("محافظ", "");
                            caption = caption.replace("صفحه", "");
                            caption = caption.replace("دوربین", "");
                            caption = caption.replace("نمایش", "");
                            caption = caption.replace("پک", "");
                            caption = caption.replace("بی رنگ ", "");
                            caption = caption.replace("مجموعه", "");
                            caption = caption.replace("موبایل", "");
                            caption = caption.replace("ال جی", "");
                            caption = caption.replace("سامسونگ", "");
                            caption = caption.replace("هوآوی", "");
                            caption = caption.replace("بی رنگ ", "");
                            caption = caption.replace("شفاف", "");
                            caption = caption.replace("ایسوس", "");
                            caption = caption.replace("شیائومی", "");
                            caption = caption.replace("مدل", "");
                            caption = caption.replace("عددی", "");
                            caption = caption.replace("دو", "");
                            caption = caption.replace("سه", "");
                            caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                            caption = caption.replace("تک", "");
                            caption = caption.replace("بی رنگ شفاف", "");
                            caption = caption.replace("|", "");
                            caption = caption.replace("سونی", "");
                            caption = caption.replace("موبایل", "");
                            caption = caption.replace("گلس", "");
                            caption = caption.replace("مناسب", "");
                            caption = caption.replace("برای", "");
                            caption = caption.replace("گوشی", "");
                            caption = caption.replace("Anti", "");
                            caption = caption.replace("Blue", "");
                            caption = caption.replace("anti", "");
                            caption = caption.replace("blue", "");
                            caption = caption.replace("light", "");
                            caption = caption.replace("حریم شخصی", "");
                            caption = caption.replace("Light", "");
                            caption = caption.replace("-", "");
                            caption = caption.replace("هورس", "");
                            caption = caption.replace("بلک بری", "");
                            caption = caption.replace("حرارت", "");
                            caption = caption.replace("دیده", "");
                            caption = caption.replace("شیشه ای", "");
                            caption = caption.replace("بسته", "");
                            caption = caption.replace("تمام چسب", "");
                            caption = caption.replace("5D", "");
                            caption = caption.replace("dual", "");
                            caption = caption.replace("Dual", "");
                            caption = caption.replace("6D", "");
                            caption = caption.replace("اپل", "");
                            caption = caption.replace("لنز", "");
                            caption = caption.replace("Horse", "");
                            caption = caption.replace("Full", "");
                            caption = caption.replace("Privacy", "");
                            caption = caption.replace("حریم شخصی", "");
                            caption = caption.replace("ساعت", "");
                            caption = caption.replace("هوشمند", "");
                            caption = caption.replace("ssp", "");
                            caption = caption.replace("SSP", "");
                            caption = caption.replace("مشکی", "");
                            caption = caption.replace("سفید", "");
                            caption = caption.replace("هوشمند", "");
                            caption = caption.replace("Ultra Clear Crystal", "");
                            caption = caption.replace("نانو", "");
                            caption = caption.replace("Flexible Screen", "");
                            caption = caption.replace("تمام", "");
                            caption = caption.replace("کاور", "");
                            caption = caption.replace("گلکسی", "");
                            caption = caption.replace("360", "");
                            caption = caption.replace("3D", "");
                            caption = caption.replace("درجه", "");
                            caption = caption.replace("به همراه", "");
                            caption = caption.replace("رنگی", "");
                            caption = caption.replace("9H", "");
                            caption = caption.replace("UTF", "");
                            caption = caption.replace("تمپرد", "");
                            caption = caption.replace("Protection", "");
                            caption = caption.replace(" و ", "");
                            LensList.add(caption);
                            lens = lens + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                            caption = originalName;
                        }
                    }

                    if (originalName.contains("LVB") || originalName.contains("Privacy") || originalName.contains("DBP") || originalName.contains("UFE") || originalName.contains("PPS") || originalName.contains("SSP") || originalName.contains("حریم شخصی") || originalName.contains("ABL") || originalName.contains("MSC") || originalName.contains("MAG") || originalName.contains(" ML ") || originalName.contains("آینه") || originalName.contains(" Shadow ") || originalName.contains("ABLS")) {
                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
                        othercount = finalCount + othercount;
//                        flex.add(caption + "   " + finalCount);
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("LVB", "");
                        caption = caption.replace("ABL", "");
                        caption = caption.replace("ML", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace("Flexible Screen", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("کاور", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("3D", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace(" و ", "");
                        if (originalName.contains("PPS")) {
                            caption = caption.replace("PPS", "Privacy 2D");
                            caption = caption.replace("PSS", "Privacy 2D");
                            caption = caption.replace("SPS", "Privacy 2D");
                        } else if (originalName.contains("SSP")) {
                            caption = caption.replace("SSP", "Privacy 5D");
                            caption = caption.replace("FPS", "Privacy 5D");
                            caption = caption.replace("PSP", "Privacy 5D");
                        }
                        if (caption.contains("ABLS")) {
                            String tmp = "Privacy";
                            others = others + " { \"name\":\"" + caption + " "
                                    + tmp + "\",\"count\":\"" + finalCount + "\"},";
                            String tmp2 = "Anti Blue";
                            others = others + " { \"name\":\"" + caption + " "
                                    + tmp + "\",\"count\":\"" + finalCount + "\"},";
                        }

                        others = others + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;
                    }
                    if (originalName.contains("FSN") || originalName.contains("نانو") || originalName.contains("ABLS") || originalName.contains("Flexible") || originalName.contains("مجموعه سه عددی") || (originalName.contains("محافظ صفحه نمایش و پشت") && originalName.contains("FSN"))) {
                        caption.replace("محافظ صفحه نمایش و پشت", "پشت و رو");
                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
                        nanocount = finalCount + nanocount;
//                        flex.add(caption + "   " + finalCount);
                        if (originalName.contains("FAG") || originalName.contains("SSP")) {
                            caption = caption.replace("مشکی", "");
                            caption = caption.replace("سفید", "");
                            caption = caption.replace("FAG", "");
                            caption = caption.replace("SSP", "");
                        }
                        if (originalName.contains("محافظ صفحه نمایش و پشت")) {
                            caption = caption.replace("محافظ صفحه نمایش و پشت", "پشت ورو");
                        }
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("مچ بند", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("5D", "");
                        caption = caption.replace("dual", "");
                        caption = caption.replace("Dual", "");
                        caption = caption.replace("6D", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("Privacy", "");
                        caption = caption.replace("حریم شخصی", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace("Flexible Screen", "");
                        caption = caption.replace("FSN", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("کاور", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace("ML", "");
                        caption = caption.replace(" و ", "");
                        FnsList.add(caption);
                        flexible = flexible + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;
                    }
                    if (originalName.contains("کیف") || originalName.contains("کاور")) {
                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
                        kifcount = finalCount + kifcount;
//                        flex.add(caption + "   " + finalCount);
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("کیف", "");
                        caption = caption.replace("کلاسوری", "");
                        caption = caption.replace("کاور", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("آنر", "Honor ");
                        caption = caption.replace("انر", "Honor ");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("LVB", "");
                        caption = caption.replace("ABL", "");
                        caption = caption.replace("ML", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace("Flexible Screen", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("3D", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace(" و ", "");
                        kif = kif + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;
                    }

                    if (originalName.contains("CGS")) {
                        int pack = convertToNumber(caption);
                        int finalCount = pack * Integer.parseInt(count2);
                        cgscount = finalCount + cgscount;
//                        flex.add(caption + "   " + finalCount);
                        caption = caption.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
                        caption = caption.replace("\\|", "");
                        caption = caption.replace("محافظ", "");
                        caption = caption.replace("صفحه", "");
                        caption = caption.replace("دوربین", "");
                        caption = caption.replace("نمایش", "");
                        caption = caption.replace("پک", "");
                        caption = caption.replace("مجموعه", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("ال جی", "");
                        caption = caption.replace("سامسونگ", "");
                        caption = caption.replace("هوآوی", "");
                        caption = caption.replace("هواوی", "");
                        caption = caption.replace("ایسوس", "");
                        caption = caption.replace("شیائومی", "");
                        caption = caption.replace("مدل", "");
                        caption = caption.replace("عددی", "");
                        caption = caption.replace("دو", "");
                        caption = caption.replace("سه", "");
                        caption = caption.replace("شیشه", "");
                        caption = caption.replace("تک", "");
                        caption = caption.replace("سرویس ویژه دیجی کالا: 7 روز تضمین بازگشت کالا", "");
                        caption = caption.replace("بی رنگ شفاف", "");
                        caption = caption.replace("|", "");
                        caption = caption.replace("سونی", "");
                        caption = caption.replace("موبایل", "");
                        caption = caption.replace("گلس", "");
                        caption = caption.replace("مناسب", "");
                        caption = caption.replace("برای", "");
                        caption = caption.replace("گوشی", "");
                        caption = caption.replace("هورس", "");
                        caption = caption.replace("بلک بری", "");
                        caption = caption.replace("حرارت", "");
                        caption = caption.replace("دیده", "");
                        caption = caption.replace("شیشه ای", "");
                        caption = caption.replace("بسته", "");
                        caption = caption.replace("تمام چسب", "");
                        caption = caption.replace("LVB", "");
                        caption = caption.replace("ABL", "");
                        caption = caption.replace("ML", "");
                        caption = caption.replace("اپل", "");
                        caption = caption.replace("لنز", "");
                        caption = caption.replace("Horse", "");
                        caption = caption.replace("Full", "");
                        caption = caption.replace("ساعت", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("هوشمند", "");
                        caption = caption.replace("Ultra Clear Crystal", "");
                        caption = caption.replace("نانو", "");
                        caption = caption.replace("Flexible Screen", "");
                        caption = caption.replace("تمام", "");
                        caption = caption.replace("گلکسی", "");
                        caption = caption.replace("360", "");
                        caption = caption.replace("3D", "");
                        caption = caption.replace("درجه", "");
                        caption = caption.replace("به همراه", "");
                        caption = caption.replace("رنگی", "");
                        caption = caption.replace("9H", "");
                        caption = caption.replace("تمپرد", "");
                        caption = caption.replace("Protection", "");
                        caption = caption.replace(" و ", "");
                        shishe = shishe + " { \"name\":\"" + caption + "\",\"count\":\"" + finalCount + "\"},";
                        caption = originalName;
                    }

                } catch (Exception e) {
                    System.out.println("exception " + e);
//                    System.out.println("filemoooooon: "+el.select(".c-ui-table__cell").get(5).text());
//                    el.select(".c-ui-table__cell").get(5).text();
//                    el.select(".table-word-wrap").get(5).text();

//                    continue;
                }
//                      String s = el.select(".table-word-wrap > img").toString();
//                      s=s.substring(10, 77);
////                            System.out.println(el.select(".table-word-wrap > img"));
//                        System.out.println(s);
//                            System.out.print("اسم محصول   :  ");
//                            System.out.println(el.select(".table-word-wrap").get(5).text());
//                            System.out.println(el.select(".table-word-wrap > img").text());

//                            TelegramGroupSender telegram = new TelegramGroupSender(el.select(".table-word-wrap").get(5).text(),chat_id);
//                            System.out.print("تعداد محصول   :  ");
//                            System.out.println(el.select(".table-word-wrap").get(7).text());
//                            System.out.println("      "+el.select(".table-word-wrap").get(5).text());
//                        System.out.print(el.select(".table-row-number-fix > span").text());
//                        System.out.print("   id =  " + Integer.parseInt(el.select(".product_variant_id > span").text()));
//                        System.out.println("  o = "+ o);
            }

        }

        simpleGlass = simpleGlass + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + simplecount + "\"},";
        full = full + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + fullcount + "\"},";
        lens = lens + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + lenscount + "\"},";
        others = others + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + othercount + "\"},";
        tablet = tablet + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + tabcount + "\"},";
        kif = kif + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + kifcount + "\"},";
        shishe = shishe + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + cgscount + "\"},";
        kheshab = kheshab + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + kheshabcount + "\"},";
        flexible = flexible + " { \"name\":\"" + "Sum" + "\",\"count\":\"" + nanocount + "\"},";

        simpleGlass = simpleGlass + "]\n" + ",";
        full = full + "]\n" + ",";
        lens = lens + "]\n" + ",";
        tablet = tablet + "]\n" + ",";
        kheshab = kheshab + "]\n" + ",";
        others = others + "]\n" + ",";
        kif = kif + "]\n" + ",";
        shishe = shishe + "]\n" + ",";
        flexible = flexible + "]\n" + "}";
        String finish = simpleGlass + full + lens + tablet + kheshab + kif + shishe + others + flexible;
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(finish);

//        JSONParser parser2 = new JSONParser();
//        JSONObject json2 = (JSONObject) parser2.parse(flexible);
        try (FileWriter file = new FileWriter("C:\\Users\\a5\\Documents\\NetBeansProjects\\Tafkik\\TablesPartOne\\data.json")) {
            file.write(json.toJSONString());
            //            file.append(json2.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            label();
//            System.out.println("\nJSON Object: " + json.toString() + json2.toJSONString());
        }

//        for (String string : clear) {
//            System.out.println(string);
//        }
//        for (String string : flex) {
//            System.out.println(string);
//        }
//        PostData postdata = new PostData(cookies);
//        CreateLinks links = new CreateLinks(cookies);
//        urlss=(Set<String>) links.getUrls();
//        for (String string : clear) {
//            System.out.println(string);
//        }
//        for (String string : flex) {
//            System.out.println(string);
//        }
//        PostData postdata = new PostData(cookies);
//        CreateLinks links = new CreateLinks(cookies);
//        urlss=(Set<String>) links.getUrls();
        SimpleRenderHorse.main(null);

        new Piriz_Label_Horse(UccList, FagList, FnsList, LensList);
//        new Horse_telegram(mahmoole);
    }

    public static String convertToEnglishDigits(String value) {
        String newValue = value.replaceAll("۱", "1").replaceAll("۲", "2").replaceAll("۳", "3").replaceAll("۴", "4").replaceAll("۵", "5")
                .replaceAll("۶", "6").replaceAll("۷", "7").replaceAll("۸", "8").replaceAll("۹", "9").replaceAll("۰", "0");
        return newValue;
    }

    public static int convertToNumber(String value) {
//        System.out.println("value  "+value);
        if (value.contains("بسته دو عددی") || value.contains("بسته دوعددی") || value.contains("بسته 2عددی") || value.contains("بسته 2 عددی")) {
            return 2;
        } else if (value.contains("بسته سه عددی") || value.contains("بسته 3 عددی") || value.contains("بسته 3عددی")) {
            return 3;
        } else {
            return 1;
        }
    }

    public static void label() throws IOException {
        Document data = Jsoup.connect("https://seller.digikala.com/package/printpackageitemseriallabel/?packageId=" + mahmoole
                + "")
                .cookies(cookies)
                .maxBodySize(0)
                .timeout(1000 * 5)
                .post();
        String tmp = data.html();
        tmp = tmp.replaceAll("/static/merged/", "https://seller.digikala.com/static/merged/");

        Document document = Jsoup.parse(tmp);

//        System.out.println(data);
        Elements labels = document.select("div.label-item");
        document.select("div.label-item").remove();
        Elements container = document.select("div.barcode-container");

        for (Element label : labels) {
            String name = label.select("div.variant-title").text();
//            System.out.println(label.select("div.variant-title").text());
            if ((name.contains("UCC") && !name.contains("تبلت")) && !name.contains("واچ") && !name.contains("ساعت") || name.contains("Ultra Clear Crystal")) {
                ucc.add(label);
            } else if (name.contains("تبلت")) {
                tablets.add(label);
            } else if (name.contains("ساعت") || name.contains("واچ")) {
                watches.add(label);
            } else if (name.contains("FSN") || name.contains("نانو")) {
                fsn.add(label);
            } else if (name.contains("FAG")) {
                adhensive.add(label);
            } else if (name.contains("CGS")) {
                cgs.add(label);
            } else if (name.contains("UTF")) {
                utf.add(label);
            } else if (name.contains("SCH")) {
                sch.add(label);
            } else {
                other.add(label);
            }
        }
        for (Element ut : utf) {
            for (Element e : container) {
                ut.appendTo(e);
            }
        }
        for (Element ot : other) {
            for (Element e : container) {
                ot.appendTo(e);
            }
        }
        for (Element sc : sch) {
            for (Element e : container) {
                sc.appendTo(e);
            }
        }
        for (Element cg : cgs) {
            for (Element e : container) {
                cg.appendTo(e);
            }
        }

        for (Element fu : adhensive) {
            for (Element e : container) {
                fu.appendTo(e);
            }
        }
        //fsn labels insert
        for (Element fs : fsn) {
            for (Element e : container) {
                fs.appendTo(e);
            }
        }
        for (Element ot : watches) {
            for (Element e : container) {
                ot.appendTo(e);
            }
        }
        for (Element ot : tablets) {
            for (Element e : container) {
                ot.appendTo(e);
            }
        }

        // UCC labels insert
        for (Element uc : ucc) {
            for (Element e : container) {
                uc.appendTo(e);
            }
        }

//        System.out.println(data);
//        System.out.println(document);
        final File f = new File("E:\\Horse\\Horse_Label.html");
        FileUtils.writeStringToFile(f, document.outerHtml(), "UTF-8");

//        System.out.println(data);
    }
}
