/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Horse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import javax.xml.parsers.*;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 *
 * @author mohsen
 */
public class Piriz_Label_Horse {

    private static String mahmoole;
    private static String caption;
    private static String originalName;
    private static String full;
    private static int index;
    private static boolean flag = false;
    private static boolean spliter = false;
    private static String tag;
    private static boolean mahmooleFlag = false;
    private static int fullcount;
    private static int j;

    private static ArrayList<String> List = new ArrayList<>();
    private static ArrayList<String> Ucc = new ArrayList<>();
    private static ArrayList<String> Fag = new ArrayList<>();
    private static ArrayList<String> Fsn = new ArrayList<>();
    private static ArrayList<String> Lens = new ArrayList<>();
    private static Element temp;
    private static Element a;
    private static Element b;
    private static Element c;
    private static Element d;
    private static Elements container;
    private static Elements finalElements;
    private static float top = (float) 0.0;
    private static float left = (float) 0.0;
    private static int counter = 1;

    public Piriz_Label_Horse(ArrayList<String> UccList, ArrayList<String> FagList, ArrayList<String> FsnList, ArrayList<String> LensList) throws IOException {
        Ucc = UccList;
        Fag = FagList;
        Fsn = FsnList;
        Lens = LensList;
        this.main(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        finalElements = new Elements();

//                    System.out.println(caption);
//                    for (int k = 0; k < finalCount; k++) {
//                    }
        caption = originalName;

        for (String string : Lens) {
            List.add(string);
        }
        List.add("LENSES");

        for (String string : Fsn) {
            List.add(string);
        }
        List.add("NANO PROTECTORS");

        for (String string : Fag) {
            List.add(string);
        }
        List.add("FULL ADHENSIVE ");

        for (String string : Ucc) {
            List.add(string);
        }
        List.add("2D GLASSES");

        for (String string : List) {
            if (string.contains("کیف") || string.contains("کاور")) {
                continue;
            }

            fullcount = convertToNumberMajmooe(string);
            if (string.contains("لنز")) {
                string = string.replace("لنز", "LENS");
            }
            if (string.contains("نوکیا")) {
                string = string.replace("نوکیا", "Nokia ");
            }
            if (string.contains("آنر")) {
                string = string.replace("آنر", "Honor");
            }
            if (string.contains("وان پلاس")) {
                string = string.replace("وان پلاس", "OnePlus");
            }
            string = string.replace("5 عددی", "");
            string = string.replace("4 عددی", "");
            string = string.replace("3 عددی", "");
            string = string.replace("2 عددی", "");
            string = string.replaceAll("ا", "").replaceAll("ب", "").replaceAll("پ", "").replaceAll("ت", "").replaceAll("ث", "").replaceAll("ج", "").replaceAll("چ", "").replaceAll("ح", "").replaceAll("خ", "").replaceAll("د", "").replaceAll("ذ", "").replaceAll("ر", "").replaceAll("ز", "").replaceAll("ژ", "").replaceAll("س", "").replaceAll("ش", "").replaceAll("ص", "").replaceAll("ض", "").replaceAll("ط", "").replaceAll("ظ", "").replaceAll("ع", "").replaceAll("غ", "").replaceAll("ف", "").replaceAll("ق", "").replaceAll("ک", "").replaceAll("گ", "").replaceAll("ل", "").replaceAll("م", "").replaceAll("ن", "").replaceAll("و", "").replaceAll("ه", "").replaceAll("ی", "").replaceAll("آ", "").replaceAll("ئ", "");
            string = string.replace("گارانتی اصالت و سلامت فیزیکی کالا", "");
            string = string.replace("سرویس ویژه دیجی کالا: 7 روز تضمین تعویض کالا", "");
            string = string.replace("\\|", "");
            string = string.replace("|", "");
            string = string.replaceAll("  ", "");
            string = string.replaceAll("   ", "");
            string = string.replace("Horse", "");
            string = string.replace("Galaxy", "");
            string = string.replace("Full", "");
            string = string.replace("Privacy", "");
            string = string.replace("Ultra Clear Crystal", "");
            string = string.replace("CSW", "");
            string = string.replace("DBP", "");
            string = string.replace("Dual", "");
            string = string.replace("4D", "");
            string = string.replace("UV", "");
            string = string.replace("Light", "");
            string = string.replace("LSP", "");
            string = string.replace("360", "");
            string = string.replace("3D", "");
            string = string.replace("FPGKK", "");
            string = string.replace("FPGK", "");
            string = string.replace("CME_08", "");
            string = string.replace("DK-K8", "");
            string = string.replace("FSP", "");
            string = string.replace("SCH", "");
            string = string.replace("DAG", "");
            string = string.replace("DCC", "");
            string = string.replace("CRM", "");
            string = string.replace("CGS", "");
            string = string.replace("SSP", "");
            string = string.replace("UFE", "");
            string = string.replace("LENS", "");
            string = string.replace("Zenfone", "Zen");
            string = string.replace("FSN", "");
            string = string.replace("SN", "");
            string = string.replace("LENS", "");
            string = string.replace("UTF", "");
            string = string.replace("9H", "");
            string = string.replace("Protection", "");
            string = string.trim();
            string = string.replace("FAG", "");
            string = string.replace("5D", "");
            string = string.replace("6D", "");
            string = string.replace("LENS", "");
            string = string.replace("Nokia", "Nokia ");
            string = string.replace("Honor", "Honor ");
            string = string.replace("OnePlus", "OnePlus ");
            if (string.length() > 27) {
                string = string.substring(0, 28);
            }
            List.set(index, string);
            index++;
        }

        File file = new File("C:\\Users\\a5\\Documents\\NetBeansProjects\\Tafkik\\Piri\\print.html");
        Document html = Jsoup.parse(file, "UTF-8", "");
        Elements labels = html.select("div.label");

//            System.out.println(labels);
        container = html.select("div.labelwrapper");
        for (Element contain : container) {

            for (int k = 0; k < List.size(); k++) {

                if (counter == 1) {

                    left = (float) 0.15;
                    String first = "<div class=\"label\" style=\"width: 0.9in; height: 0.5in; left: " + left + "in; top: " + top + "in;\">"
                            + "<div class=\"label-text ui-widget-content\"><p>" + List.get(k) + "</p></div>" + "</div>";
                    Element tag = Jsoup.parse(first, "", Parser.xmlParser());
                    tag.appendTo(contain);
                    counter++;

                } else if (counter == 2) {
                    left = (float) 1.18;

                    String first = "<div class=\"label\" style=\"width: 0.9in; height: 0.5in; left: " + left + "in; top: " + top + "in;\">"
                            + "<div class=\"label-text ui-widget-content\"><p>" + List.get(k) + "</p></div>" + "</div>";
                    Element tag = Jsoup.parse(first, "", Parser.xmlParser());
                    tag.appendTo(contain);

//                    b.appendTo(contain);
                    counter++;

                } else if (counter == 3) {
                    left = (float) 2.23;
                    String first = "<div class=\"label\" style=\"width: 0.9in; height: 0.5in; left: " + left + "in; top: " + top + "in;\">"
                            + "<div class=\"label-text ui-widget-content\"><p>" + List.get(k) + "</p></div>" + "</div>";
                    Element tag = Jsoup.parse(first, "", Parser.xmlParser());
                    tag.appendTo(contain);

//                    c.appendTo(contain);
                    counter++;

                } else if (counter == 4) {
                    left = (float) 3.28;
                    String first = "<div class=\"label\" style=\"width: 0.9in; height: 0.5in; left: " + left + "in; top: " + top + "in;\">"
                            + "<div class=\"label-text ui-widget-content\"><p>" + List.get(k) + "</p></div>" + "</div>";
                    Element tag = Jsoup.parse(first, "", Parser.xmlParser());
                    tag.appendTo(contain);
//                    d.appendTo(contain);

                    top = (float) (top + 0.5955);
                    counter = 1;
                }
            }
        }
//        for (String li : UccList) {
//            System.out.println("Model name    " + li);
//        }
//        System.out.println("final .   " + finalElements);
//        for (Element contain : container) {
//            for (Element finalElement : finalElements) {
//                finalElement.appendTo(contain);
//            }
//        }

////        html.select("<root>").remove();
//        html.select("<#root>").remove();
//        html.select("<#/root>").remove();
//        for (TextNode textNode : html.textNodes()) {
//            System.out.println(textNode.toString());
//        }
        String htmlString = html.toString().replaceAll("<#root>", "").replaceAll("</#root>", "");
        Document document = Jsoup.parse(htmlString, "");
//        System.out.println(htmlString);
        final File f = new File("E:\\Horse\\White_Label_Opera.html");
        FileUtils.writeStringToFile(f, document.outerHtml(), "UTF-8");
    }

//        System.out.println(html);
    public static String convertToEnglishDigits(String value) {
        String newValue = value.replaceAll("۱", "1").replaceAll("۲", "2").replaceAll("۳", "3").replaceAll("۴", "4").replaceAll("۵", "5")
                .replaceAll("۶", "6").replaceAll("۷", "7").replaceAll("۸", "8").replaceAll("۹", "9").replaceAll("۰", "0");
        return newValue;
    }

    public static int convertToNumber(String value) {
//        System.out.println("value  "+value);
        if (value.contains("بسته دو عددی") || value.contains("بسته دوعددی")) {
            return 2;
        } else if (value.contains("بسته سه عددی")) {
            return 3;
        } else {
            return 1;
        }
    }

    public static int convertToNumberMajmooe(String value) {
//        System.out.println("value  "+value);
        if (value.contains("مجموعه دو عددی") || value.contains("مجموعه دوعددی")) {
            return 2;
        } else if (value.contains("مجموعه سه عددی")) {
            return 3;
        } else if (value.contains("مجموعه چهار عددی")) {
            return 4;
        } else if (value.contains("مجموعه پنج عددی") || value.contains("مجموعه 5 عددی")) {
            return 5;
        } else {
            return 1;
        }
    }

}
