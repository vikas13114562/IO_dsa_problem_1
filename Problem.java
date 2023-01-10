
public class Problem {
    public static void main(String[] args){
        boolean arr[] = new boolean[1];
        solve(13,0,0,0,0,16500,arr);
        if(!arr[0]) System.out.print("Result not possible");
    }
    
    static void solve(int day, int t, int p, int c,int amount, int total,boolean flag[] ) {
        
        if(amount == total) {
             System.out.print("T:"+t+" P:"+p+" C:"+c);
             flag[0] = true;
            System.out.println();
            return;
        }
        if(day < 4) return;
//         Theatre first
        if(day >= 5){ 
            day -= 5;
            t += 1;
            
            amount += 1500*day+p*1000*day+c*3000*day;
            solve(day,t,p,c,amount,total,flag);
            amount -= 1500*day+p*1000*day+c*3000*day;
            day += 5;
            t -= 1;
            
        }
        // Pub
        if(day >= 4){ 
            day -= 4;
            p += 1;
            
            amount += t*1500*day+1000*day+c*3000*day;
            solve(day,t,p,c,amount,total,flag);
            amount -= t*1500*day+1000*day+c*3000*day;
            day += 4;
            p -= 1;
            
        }

        // Commercial Park
        if(day >= 10) { 
           day -= 10;
            c += 1;
            
            amount += t*1500*day+p*1000*day+3000*day;
            solve(day,t,p,c,amount,total,flag);
            amount -= t*1500*day+p*1000*day+3000*day;
            day += 10;
            c -= 1;
            
        }
        
    } 
}
