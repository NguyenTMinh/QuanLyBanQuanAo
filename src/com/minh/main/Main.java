package com.minh.main;

import java.io.IOException;

import com.minh.thread.MainThread;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainThread mainThread = new MainThread();
		try {
			mainThread.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
