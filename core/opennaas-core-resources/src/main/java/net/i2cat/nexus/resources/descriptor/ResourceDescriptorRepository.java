package net.i2cat.nexus.resources.descriptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.RollbackException;

import net.i2cat.nexus.persistence.GenericOSGiJpaRepository;
import net.i2cat.nexus.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResourceDescriptorRepository extends GenericOSGiJpaRepository<ResourceDescriptor, String> {

	private static Log	logger	= LogFactory.getLog(ResourceDescriptorRepository.class);

	public ResourceDescriptorRepository() {
		super();
	}

	public List<ResourceDescriptor> getResourceDescriptors(String type) {
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("type", type);
		return this.findByNamedQueryAndNamedParams("resourceDescriptor.findByType", queryParams);
	}

	@Override
	public ResourceDescriptor save(ResourceDescriptor resourceDescriptor) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(resourceDescriptor);
			// getEntityManager().persist(resourceDescriptor);
			getEntityManager().getTransaction().commit();
		} catch (RollbackException ex) {
			getEntityManager().getTransaction().rollback();
			throw new PersistenceException("Exception while saving resourceDescriptor. Save operation has been rolledBack.", ex);
		}
		return resourceDescriptor;
	}

	@Override
	public void delete(ResourceDescriptor resourceDescriptor) {
		try {
			getEntityManager().getTransaction().begin();
			ResourceDescriptor attachedResourceDescriptor = findById(resourceDescriptor.getId());
			getEntityManager().remove(attachedResourceDescriptor);
			getEntityManager().getTransaction().commit();
		} catch (RollbackException ex) {
			getEntityManager().getTransaction().rollback();
			throw new PersistenceException("Exception while removing ResourceDescriptor. Delete operation has been rolledBack.", ex);
		}
	}
}