package org.opennaas.extensions.vcpe.manager;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.opennaas.extensions.vcpe.model.VCPENetworkModel;

@Path("/")
public interface IVCPENetworkManager {

	/**
	 * Create a VCPE infrastructure of VCPEResource from model
	 * 
	 * @return the id if the VCPE has been created
	 * @throws VCPENetworkManagerException
	 */
	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String create(VCPENetworkModel vcpeNetworkModel) throws VCPENetworkManagerException;

	/**
	 * Remove a VCPE infrastructure of the resource with id = vcpeNetworkId
	 * 
	 * @param vcpeNetworkId
	 * @return true if the VCPE has been removed, false otherwise
	 * @throws VCPENetworkManagerException
	 */
	@Path("/remove/{id}")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Boolean remove(@PathParam("id") String vcpeNetworkId) throws VCPENetworkManagerException;

	/**
	 * Get the VCPENetwork with id = vcpeNetworkId
	 * 
	 * @param vcpeNetworkId
	 * @return VCPENetworkModel
	 * @throws VCPENetworkManagerException
	 */
	@Path("/getVCPENetworkById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public VCPENetworkModel getVCPENetworkById(@PathParam("id") String vcpeNetworkId) throws VCPENetworkManagerException;

	/**
	 * Get all VCPENetworks
	 * 
	 * @return
	 * @throws VCPENetworkManagerException
	 */
	@Path("/getAllVCPENetworks")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<VCPENetworkModel> getAllVCPENetworks() throws VCPENetworkManagerException;

	/**
	 * Check if a VLAN is available or not in a interface
	 * 
	 * @param vcpeId
	 * @param ifaceName
	 * @param vlan
	 * @return true if is available
	 * @throws VCPENetworkManagerException
	 */
	@Path("/isVLANFree")
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Boolean isVLANFree(@QueryParam("vcpeId") String vcpeId, @QueryParam("vlan") String vlan, @QueryParam("ifaceName") String ifaceName)
			throws VCPENetworkManagerException;

	/**
	 * Check if an IP is available or not in the environment
	 * 
	 * @param vcpeId
	 * @param iface
	 * @return true if is available
	 * @throws VCPENetworkManagerException
	 */
	@Path("/isIPFree")
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Boolean isIPFree(@QueryParam("vcpeId") String vcpeId, @QueryParam("ip") String ip) throws VCPENetworkManagerException;

	/**
	 * Check if an interface is available or not in the environment
	 * 
	 * @param vcpeId
	 * @param iface
	 * @return true if is available
	 * @throws VCPENetworkManagerException
	 */
	@Path("/isInterfaceFree")
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Boolean isInterfaceFree(@QueryParam("vcpeId") String vcpeId, @QueryParam("iface") String iface) throws VCPENetworkManagerException;
}