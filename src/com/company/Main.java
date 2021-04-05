package com.company;

import my_bran_spanking_new_package.now_we_add;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File quelldatei_kaijus = new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus.xml");
        File hinzufuegen = new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus_zwischenlager.xml");
        now_we_make.a_kaiju("Zumpfsti", 17);
        now_we_add.a_kaiju(quelldatei_kaijus, hinzufuegen, new File("C:\\Users\\paulf\\IdeaProjects\\test_19\\src\\my_bran_spanking_new_package\\kaijus_aussi.xml"));

    }
}
