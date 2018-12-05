package sheva;

import java.util.List;

@SuppressWarnings("ALL")
public class Comparator {
    private String el1;
    private String el2;
    private String el3;

    private String to1;
    private String to2;
    private String to3;

    public void setBaseValues(String to1, String to2, String to3) {
        this.to1 = to1;
        this.to2 = to2;
        this.to3 = to3;
    }

    public void setCompareElementsValues(List<String> list) {
        el1 = list.get(0);
        el2 = list.get(1);
        el3 = list.get(2);
    }

    public boolean compare() {
        boolean isTo1Used = false;
        boolean isTo2Used = false;
        boolean isTo3Used = false;
        boolean isEl1Ok = false;
        boolean isEl2Ok = false;
        boolean isEl3Ok = false;
        if (to1.equals(el1)) {
            isTo1Used = true;
            isEl1Ok = true;
        } else if (to2.equals(el1)) {
            isTo2Used = true;
            isEl1Ok = true;
        } else if (to3.equals(el1)) {
            isTo3Used = true;
            isEl1Ok = true;
        }
        if (isEl1Ok) {
            if (!isTo1Used) {
                if (to1.equals(el2)) {
                    isTo1Used = true;
                    isEl2Ok = true;
                }
                if (!isTo1Used)
                    if (to1.equals(el3)) {
                        isTo1Used = true;
                        isEl3Ok = true;
                    }
            }
            if (!isTo2Used) {
                if (to2.equals(el2)) {
                    isTo2Used = true;
                    isEl2Ok = true;
                }
                if (!isTo2Used)
                    if (to2.equals(el3)) {
                        isTo2Used = true;
                        isEl3Ok = true;
                    }
            }
            if (!isTo3Used) {
                if (to3.equals(el3)) {
                    isTo3Used = true;
                    isEl2Ok = true;
                }
                if (!isTo3Used)
                    if (to3.equals(el3)) {
                        isTo3Used = true;
                        isEl3Ok = true;
                    }
            }
        }
        return isEl1Ok && isEl2Ok && isEl3Ok && isTo1Used && isTo2Used && isTo3Used;
    }
}
