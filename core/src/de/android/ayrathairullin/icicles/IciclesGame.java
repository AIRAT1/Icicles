package de.android.ayrathairullin.icicles;

import com.badlogic.gdx.Game;

import de.android.ayrathairullin.icicles.screens.IciclesScreen;

public class IciclesGame extends Game {

	@Override
	public void create () {
		setScreen(new IciclesScreen());
	}
}
