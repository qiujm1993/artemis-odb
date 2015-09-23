package com.artemis.systems;

import com.artemis.*;
import com.artemis.utils.Bag;

/**
 * A typical entity system.
 * <p>
 * Use this when you need to process entities possessing the provided component
 * types.
 * </p>
 * 
 * @author Arni Arent
 */
public abstract class EntityProcessingSystem extends EntitySystem {
	/**
	 * Creates a new EntityProcessingSystem.
	 *
	 * @param aspect
	 *			the aspect to match entities
	 */
	public EntityProcessingSystem(Aspect.Builder aspect) {
		super(aspect);
	}

	/**
	 * Process a entity this system is interested in.
	 *
	 * @param e
	 *			the entity to process
	 */
	protected abstract void process(Entity e);

	@Override
	protected final void processSystem() {
		Bag<Entity> entities = getEntities();
		Object[] array = entities.getData();
		for (int i = 0, s = entities.size(); s > i; i++) {
			process((Entity)array[i]);
		}
	}
}
