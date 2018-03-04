package de.android.ayrathairullin.icicles;

import com.badlogic.gdx.Game;

import de.android.ayrathairullin.icicles.Constants.Difficulty;
import de.android.ayrathairullin.icicles.screens.DifficultyScreen;
import de.android.ayrathairullin.icicles.screens.IciclesScreen;

public class IciclesGame extends Game {
	@Override
	public void create () {
		showDifficultyScreen();
	}

	public void showDifficultyScreen() {
		setScreen(new DifficultyScreen(this));
	}

	public void showIciclesScreen(Difficulty difficulty) {
		setScreen(new IciclesScreen(this, difficulty));
	}
}
