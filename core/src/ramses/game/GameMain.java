package ramses.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class GameMain extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img, img2, img3, beer;
    float accelX, accelX2, accelX3,accelX4;
    float accelY,accelY4;
    float accelZ;
    boolean beerPaint;


    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("profe.png");
        img2 = new Texture("profe2.png");
        img3 = new Texture("profe3.png");
        beer = new Texture("beer.png");

        beerPaint = true;
        accelX2 = 400;
        accelX3 = 600;
        accelX = 200;
        accelY = 200;
        //System.out.println("WIDTH: " + Gdx.graphics.getWidth());
        //System.out.println("HEIGHT: " + Gdx.graphics.getHeight());

    }


    //Metodo infinito, para que sea constante
    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //System.out.println("X: " + Gdx.input.getAccelerometerX() + " Y: " + Gdx.input.getAccelerometerY());
        //System.out.println("X: " + Gdx.input.getAccelerometerX());


        if (Gdx.input.getAccelerometerY() < 0) {
            //go left
            accelX += Gdx.input.getAccelerometerY();
            accelX2 += Gdx.input.getAccelerometerY();
            accelX3 += Gdx.input.getAccelerometerY();
        } else if (Gdx.input.getAccelerometerY() > 0) {
            //go right
            accelX += Gdx.input.getAccelerometerY();
            accelX2 += Gdx.input.getAccelerometerY();
            accelX3 += Gdx.input.getAccelerometerY();
        }


        if (Gdx.input.getAccelerometerX() < 0) {
            //go up
            accelY -= Gdx.input.getAccelerometerX();
        } else if (Gdx.input.getAccelerometerX() > 0) {
            //go down
            accelY -= Gdx.input.getAccelerometerX();
        }


//        if (accelX < 0) accelX = 0;
//        if (accelX > Gdx.graphics.getWidth() - 200) accelX = Gdx.graphics.getWidth() - 200;
//        if (accelY < 0) accelY = 0;
//        if (accelY < Gdx.graphics.getHeight() - 200) accelY = Gdx.graphics.getHeight() - 200;
//
        batch.begin();

        if(!beerPaint){
            accelX4 = random();
            accelY4 = random();
            beerPaint = true;
        }

        batch.draw(img, accelX, accelY, 200, 200);
        batch.draw(img2, accelX2, accelY, 200, 200);
        batch.draw(img3, accelX3, accelY, 200, 200);
        batch.draw(beer, accelX4, accelY4, 200, 200);



        batch.end();
    }


    //Inverso al create, destruye la memoria
    @Override
    public void dispose() {
        batch.dispose();
        beer.dispose();
        img3.dispose();
        img2.dispose();
        img.dispose();
    }


    public int random() {

        final int random = new Random().nextInt(1080) + 1;

        return random;
    }


}
