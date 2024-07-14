/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualizer;

import static  sortingvisualizer.SortingVisualizer.paused;
import static sortingvisualizer.SortingVisualizer.sortingThread;

public class BubbleSort implements Runnable{
	
	private final Integer[] toBeSorted;
	private final VisualizerFrame frame;
        
	
        
	public BubbleSort(Integer[] toBeSorted, VisualizerFrame frame) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;	
	}
	
        @Override
	public void run() {
		
			bsort();
                        
		
		SortingVisualizer.isSorting=false;
	}
	
	public void bsort() {
		int temp = 0;
		boolean swapped = false;
		for(int i = 0; i<toBeSorted.length-1; i++){
                    
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}
                                if(paused == true)
                        {
                           
                         synchronized(sortingThread)
                            
                         {   // Pause
                                try 
                                {sortingThread.wait();
                                } 
                                catch (InterruptedException e) 
                                {
                                }
                        }
                        }
                             
                                      
				frame.reDrawArray(toBeSorted, j, j+1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
                        
			if (!swapped) break;
		}
        }
}
    

