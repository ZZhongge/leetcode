package Solution200_250;

///碰撞问题
///防止溢出，不到万不得已不要运算
class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int tmpx = Math.min(C, G) - Math.max(A, E);
        int width = tmpx < 0? 0 : tmpx;
        int tmpy = Math.min(D, H) - Math.max(B, F);
        int height = tmpy< 0? 0 : tmpy;
        return (C-A) * (D - B) + (G - E) * (H - F) - width * height;
    }
}
