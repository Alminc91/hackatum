package com.parkproject.parkit;

import android.os.Bundle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import java.net.MalformedURLException;

import android.content.Intent;

public class AndroidLauncher extends AndroidApplication{
	private MobileServiceClient mClient;
	static MobileServiceTable<ParkItData> table;
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			mClient = new MobileServiceClient("https://parkit.azurewebsites.net", this);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		table = mClient.getTable(ParkItData.class);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new ParkIt(new GameCallback() {
			@Override
			public void startActivity() {

				starte();
			}
		}), config);
	}
	public void starte() {
		Intent intent = new Intent(this, MapsActivity.class);
		startActivity(intent);
	}
}
