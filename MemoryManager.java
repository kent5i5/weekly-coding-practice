/*
* Create a function that takes the memory size (ms is a string type) as an argument and returns the actual memory size.

* Examples
* actualMemorySize("32GB") --> "29.76GB"
* 
* actualMemorySize("2GB") --> "1.86GB"
* 
* actualMemorySize("512MB") --> "476MB"
* 
* Notes
* -The actual storage loss on a USB device is 7% of the overall memory size!
* -If the actual memory size was greater than 1 GB, rountd your result to two decimal places.
* -If the memory size after adjustment is smaller then 1 GB, return the resul in MB. 
*
*/


public class  MemoryManager {
    public String actualMemorySize(String memorySize){
        double ms = Double.parseDouble(memorySize.replaceAll("[a-zA-Z]B",""));
        if (memorySize.contains("GB")){
            ms = ms*0.93;
            if (ms < 1){
                // if ms is less than 1 GB , convert it to mb by multipling 1000
                ms = ms*1000;
                int ms2 = (int)ms;
                return ms2 + "MB";
            }
            ms = Math.round(ms * 100.0) / 100.0;
            return ms + "GB";
        } else if (memorySize.contains("MB")){
            ms = ms*0.93;
            int ms2 = (int)ms;
            return ms2 + "MB";
        }
        return "";
        

    }    

    public static void main(String[] args){

        MemoryManager m = new MemoryManager();
        System.out.println(m.actualMemorySize("32GB"));
        System.out.println(m.actualMemorySize("2GB"));
        System.out.println(m.actualMemorySize("512MB"));
        System.out.println(m.actualMemorySize("1GB"));

        /* Output:
        29.76GB
        1.86GB
        476MB
        930MB
        */
    }
}