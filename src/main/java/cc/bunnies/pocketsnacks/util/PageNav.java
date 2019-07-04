package cc.bunnies.pocketsnacks.util;

import java.util.ArrayList;
import java.util.List;

public class PageNav {

    public static int safePage(int page, int size, int total) {
        int cur_page = page > 0 ? page : 1;
        int totalPage = total % size == 0 ? total / size : total / size + 1;
        cur_page = cur_page > totalPage ? totalPage : cur_page;
        return cur_page;
    }

    public static List<Integer> makePageNav(int page, int size, int total) {
        ArrayList<Integer> result = new ArrayList<>();
        int totalPage = total % size == 0 ? total / size : total / size + 1;
        int start = 1;
        int end = totalPage;
        if (totalPage > 6) {
            start = page - 3;
            start = start > 0 ? start : 1;
            end = start + 5;
            if (end > totalPage) {
                end = totalPage;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(i);
        }
        return result;
    }
}