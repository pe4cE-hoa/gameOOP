package bullet;

import gameobject.ParticularObject;
import gameobject.ParticularObjectManager;
import state.GameWorldState;

public class BulletManager extends ParticularObjectManager {

    public BulletManager(GameWorldState gameWorld) {
        super(gameWorld);
    }

    @Override
    public void UpdateObjects() {
        super.UpdateObjects(); 
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){
                
                ParticularObject object = particularObjects.get(id);
                
                if(object.isObjectOutOfCameraView() || object.getState() == ParticularObject.DEATH){
                    particularObjects.remove(id);
                }
            }
        }
    }   
    
}