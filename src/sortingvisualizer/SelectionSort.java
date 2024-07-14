/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualizer;

import static sortingvisualizer.SortingVisualizer.paused;
import static sortingvisualizer.SortingVisualizer.sortingThread;

public class SelectionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	private boolean fast;
	
	public SelectionSort(Integer[] toBeSorted, VisualizerFrame frame) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
	}
	public void run() {
		
			selectsort();
		
		SortingVisualizer.isSorting=false;
	}
	
	public void selectsort() {
		int temp = 0;
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}
                                if(paused == true)
                        {
                           
                            synchronized(sortingThread)
                            {
                                // Pause
                                try 
                                {sortingThread.wait();
                                } 
                                catch (InterruptedException e) 
                                {
                                }
                            }
                        }
				frame.reDrawArray(toBeSorted, selected, j-1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
		frame.reDrawArray(toBeSorted);
	}
}
    


