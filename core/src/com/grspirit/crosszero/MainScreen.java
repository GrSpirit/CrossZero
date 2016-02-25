package com.grspirit.crosszero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class MainScreen implements Screen {
	/*
	//SpriteBatch batch;
	Grid field;
	ShapeRenderer shapeRenderer;
	OrthographicCamera camera;
	//Texture img;

	private float rect_size;
	*/
	GameWorld world;
	GameRender renderer;

	public MainScreen () {
		/*
		//batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, X0Game.WIDTH, X0Game.HEIGHT);
		shapeRenderer = new ShapeRenderer();
		//img = new Texture("badlogic.jpg");
		rect_size = X0Game.HEIGHT / Grid.MAX_SIZE;
		field = Grid.getInstance();
		*/
		world = new GameWorld();
		renderer = new GameRender(world);
		Gdx.input.setInputProcessor(new InputHandler(world));
	}

	@Override
	public void render (float delta) {
		world.update();
		renderer.render();
		/*
		camera.update();

		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		drawField();

        if (Gdx.input.isTouched()) {
            Vector3 touchPosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPosition);
            int x = (int)(touchPosition.x / rect_size);
            int y = (int)(touchPosition.y / rect_size);
            //crow.setX((int)touchPosition.x);
        }
		shapeRenderer.end();
		*/
	}

	/*public void drawField() {

        Color blueColor = new Color(0.5f, 0.5f, 1f, 1);
        Color redColor = new Color(0xFF0000FF);
        Color greenColor = new Color(0x00FF00FF);
		for (int x = 0; x < Grid.MAX_SIZE; x++) {
			for (int y = 0; y < Grid.MAX_SIZE; y++) {
                if (shapeRenderer.getColor() != blueColor) shapeRenderer.setColor(blueColor);

				shapeRenderer.rect(x * rect_size, y * rect_size, rect_size, rect_size);
				if(field.getValue(x, y) == Grid.CROSS) {
                    shapeRenderer.setColor(redColor);
					shapeRenderer.line(x * rect_size, y * rect_size, (x + 1) * rect_size, (y + 1) * rect_size);
					shapeRenderer.line((x + 1) * rect_size, y * rect_size, (x) * rect_size, (y + 1) * rect_size);
				}
				else if (field.getValue(x, y) == Grid.ZERO) {
                    shapeRenderer.setColor(greenColor);
					shapeRenderer.ellipse((x + 0.5f) * rect_size, (y + 0.5f) * rect_size, rect_size / 2f, rect_size / 2f);
				}
			}
		}
	}*/

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }
}
