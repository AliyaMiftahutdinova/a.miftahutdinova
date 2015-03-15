package ru.kpfu.itis.group11408.Miftahutdinova.searcher;

import java.io.File;

public class Searcher{
	
	public void find(String path, String name, double count, boolean flag){
		if(count != 0){
			File fl = new File(path);
			File[] array = fl.listFiles();
			if(array != null){
				for(int i = 0; i < array.length; i++){
					if(array[i].getName().contains(name)){
						showResult(array[i], flag);
					}else if(array[i].isDirectory()){
						find(array[i].getAbsolutePath(), name, count - 1, flag);
					}
				}
			}
		}
	}

    private void showResult(File fl, boolean flag){
        if(fl.isFile()){
            System.out.println(fl.getAbsolutePath());
        }else if(fl.isDirectory() && flag){
            System.out.println(fl.getAbsolutePath());
        }
    }
	
}
