package hc.healthcheck;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Hp on 4/8/2017.
 */

public class Chuoi extends Activity {
        public static final String KEY_DANHGIA = "hc.healthcheck";
        public static final int CHON_GAY = 0;
        public static final int CHON_BINHTHUONG = 1;
        public static final int CHON_MAP1 = 2;
        public static final int CHON_MAP2 = 3;
        public static final int CHON_MAP3 = 4;
        private final String gayPuzzle = "asdasda" +
                "asdasdasd" +
                "asdasdasd";
        private final String btPuzzle = "asdasd";
        private final String map1Puzzle = "map1";
        private final String map2Puzzle = "map2";
        private final String map3Puzzle = "map3";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int diff = getIntent().getIntExtra(KEY_DANHGIA, CHON_GAY);

    }
    private  int[] getPuzzle(int diff){
        String puz;
        switch(diff){
            case CHON_GAY:
                puz = gayPuzzle;
                break;
            case CHON_BINHTHUONG:
                puz = btPuzzle;
                break;
            case CHON_MAP1:
                puz = map1Puzzle;
                break;
            case CHON_MAP2:
                puz = map2Puzzle;
                break;
            case CHON_MAP3:
                puz = map3Puzzle;
                break;
        }
        return  null;
    }
}

