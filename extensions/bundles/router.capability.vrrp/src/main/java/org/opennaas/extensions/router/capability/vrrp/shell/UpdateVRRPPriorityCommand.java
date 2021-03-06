package org.opennaas.extensions.router.capability.vrrp.shell;

import java.util.List;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.opennaas.core.resources.IResource;
import org.opennaas.core.resources.ResourceException;
import org.opennaas.core.resources.shell.GenericKarafCommand;
import org.opennaas.extensions.router.capability.vrrp.IVRRPCapability;
import org.opennaas.extensions.router.model.ComputerSystem;
import org.opennaas.extensions.router.model.IPProtocolEndpoint;
import org.opennaas.extensions.router.model.NetworkPort;
import org.opennaas.extensions.router.model.ProtocolEndpoint;
import org.opennaas.extensions.router.model.Service;
import org.opennaas.extensions.router.model.VRRPGroup;
import org.opennaas.extensions.router.model.VRRPProtocolEndpoint;

/**
 * @author Julio Carlos Barrera
 */
@Command(scope = "vrrp", name = "updatePriority", description = "Update VRRP priority")
public class UpdateVRRPPriorityCommand extends GenericKarafCommand {

	@Argument(index = 0, name = "resourceType:resourceName", description = "Name of the router to update the VRRP priority", required = true, multiValued =
			false)
	private String	resourceId;

	@Argument(index = 1, name = "vrrpGroupId", description = "The VRRP group ID", required = true, multiValued =
			false)
	private int		vrrpGroupId;

	@Argument(index = 2, name = "priority", description = "The priority of the router inside this VRRP group", required = true, multiValued =
			false)
	private int		priority;

	@Override
	protected Object doExecute() throws Exception {
		printInitCommand("Update VRRP priority");
		try {
			IResource router = getResourceFromFriendlyName(resourceId);

			IVRRPCapability vrrpCapability = (IVRRPCapability) router.getCapabilityByInterface(IVRRPCapability.class);

			VRRPGroup vrrpGroup = null;
			// ComputerSystem copy
			ComputerSystem newRouter = new ComputerSystem();
			// VRRPGroup copy
			VRRPGroup newVRRPGroup = new VRRPGroup();
			List<Service> services = ((ComputerSystem) router.getModel()).getHostedService();
			for (Service service : services) {
				if (service instanceof VRRPGroup) {
					VRRPGroup candidate = (VRRPGroup) service;
					if (candidate.getVrrpName() == vrrpGroupId) {
						vrrpGroup = candidate;
						newVRRPGroup.setVrrpName(vrrpGroup.getVrrpName());
						newRouter.addHostedService(newVRRPGroup);
						break;
					}
				}
			}

			VRRPProtocolEndpoint vrrpProtocolEndpoint = null;
			// VRRPProtocolEndpoint copy
			VRRPProtocolEndpoint newVRRPProtocolEndpoint = new VRRPProtocolEndpoint();
			if (vrrpGroup != null) {
				List<ProtocolEndpoint> protocolEndpoints = vrrpGroup.getProtocolEndpoint();
				for (ProtocolEndpoint protocolEndpoint : protocolEndpoints) {
					if (((VRRPGroup) ((VRRPProtocolEndpoint) protocolEndpoint).getService()).getVrrpName() == vrrpGroup.getVrrpName()) {
						vrrpProtocolEndpoint = (VRRPProtocolEndpoint) protocolEndpoint;
						// set priority
						newVRRPProtocolEndpoint.setPriority(priority);
						newVRRPProtocolEndpoint.setService(newVRRPGroup);
						// IPProtocolEndpoint copy
						IPProtocolEndpoint ipProtocolEndpoint = (IPProtocolEndpoint) vrrpProtocolEndpoint.getBindedProtocolEndpoints().get(0);
						IPProtocolEndpoint newIPProtocolEndpoint = new IPProtocolEndpoint();
						newIPProtocolEndpoint.setIPv4Address(ipProtocolEndpoint.getIPv4Address());
						newIPProtocolEndpoint.setSubnetMask(ipProtocolEndpoint.getSubnetMask());
						newVRRPProtocolEndpoint.bindServiceAccessPoint(newIPProtocolEndpoint);
						// NetworkPort copy
						NetworkPort networkPort = (NetworkPort) ipProtocolEndpoint.getLogicalPorts().get(0);
						NetworkPort newNetworkPort = new NetworkPort();
						newNetworkPort.setName(networkPort.getName());
						newNetworkPort.setPortNumber(networkPort.getPortNumber());
						newNetworkPort.addProtocolEndpoint(newIPProtocolEndpoint);
						newRouter.addLogicalDevice(newNetworkPort);
						break;
					}
				}
				if (vrrpProtocolEndpoint != null) {
					vrrpCapability.updateVRRPPriority(newVRRPProtocolEndpoint);
					printEndCommand();
					return null;
				}
				else {
					printError("Error updating VRRP priority. No VRRPProtocolEndpoint found");
				}
			} else {
				printError("Error updating VRRP priority. No VRRPGroup found");
			}
			printEndCommand();
			return -1;
		} catch (ResourceException e) {
			printError(e);
			printEndCommand();
			return -1;
		} catch (Exception e) {
			printError("Error updating VRRP priority.");
			printError(e);
			printEndCommand();
			return -1;
		}
	}
}
