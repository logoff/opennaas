/**
 * This file was auto-generated by mofcomp -j version 1.0.0 on Wed Jan 12
 * 09:21:06 CET 2011.
 */

package net.i2cat.mantychore.model;

import java.io.*;
import java.lang.Exception;

/**
 * This Class contains accessor and mutator methods for all properties defined in the CIM class AllocationSchedulingElement as well as methods
 * comparable to the invokeMethods defined for this class. This Class implements the AllocationSchedulingElementBean Interface. The CIM class
 * AllocationSchedulingElement is described as follows:
 * 
 * This class is a subclass of the abstract class SchedulingElement. It introduces five new properties to support bandwidth-based scheduling. As is
 * the case with all subclasses of SchedulingElement, the input associated with an instance of AllocationSchedulingElement is of one of two types:
 * either a queue, or another scheduler.
 */
public class AllocationSchedulingElement extends SchedulingElement implements
		Serializable {

	/**
	 * This constructor creates a AllocationSchedulingElementBeanImpl Class which implements the AllocationSchedulingElementBean Interface, and
	 * encapsulates the CIM class AllocationSchedulingElement in a Java Bean. The CIM class AllocationSchedulingElement is described as follows:
	 * 
	 * This class is a subclass of the abstract class SchedulingElement. It introduces five new properties to support bandwidth-based scheduling. As
	 * is the case with all subclasses of SchedulingElement, the input associated with an instance of AllocationSchedulingElement is of one of two
	 * types: either a queue, or another scheduler.
	 */
	public AllocationSchedulingElement() {
	};

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property AllocationUnits.
	 */

	public enum AllocationUnits {
		BYTES,
		PACKETS,
		CELLS
	}

	private AllocationUnits	allocationUnits;

	/**
	 * This method returns the AllocationSchedulingElement.allocationUnits property value. This property is described as follows:
	 * 
	 * A 16-bit unsigned integer enumeration that identifies the units in which the BandwidthAllocation and BurstAllocation properties are expressed.
	 * The following values are defined: - Bytes(1) - Packets(2) - Cells(3) (fixed-size, for example, ATM) If no value is specified, 1 ("Bytes")
	 * should be assumed.
	 * 
	 * @return int current allocationUnits property value
	 * @exception Exception
	 */
	public AllocationUnits getAllocationUnits() {

		return this.allocationUnits;
	} // getAllocationUnits

	/**
	 * This method sets the AllocationSchedulingElement.allocationUnits property value. This property is described as follows:
	 * 
	 * A 16-bit unsigned integer enumeration that identifies the units in which the BandwidthAllocation and BurstAllocation properties are expressed.
	 * The following values are defined: - Bytes(1) - Packets(2) - Cells(3) (fixed-size, for example, ATM) If no value is specified, 1 ("Bytes")
	 * should be assumed.
	 * 
	 * @param int new allocationUnits property value
	 * @exception Exception
	 */
	public void setAllocationUnits(AllocationUnits allocationUnits) {

		this.allocationUnits = allocationUnits;
	} // setAllocationUnits

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property bandwidthAllocation.
	 */
	private long	bandwidthAllocation;

	/**
	 * This method returns the AllocationSchedulingElement.bandwidthAllocation property value. This property is described as follows:
	 * 
	 * A 32-bit bit unsigned integer defining the number of 'units' per second that should be allocated to the associated input. 'Units' are
	 * identified by the AllocationUnits property.
	 * 
	 * @return long current bandwidthAllocation property value
	 * @exception Exception
	 */
	public long getBandwidthAllocation() {

		return this.bandwidthAllocation;
	} // getBandwidthAllocation

	/**
	 * This method sets the AllocationSchedulingElement.bandwidthAllocation property value. This property is described as follows:
	 * 
	 * A 32-bit bit unsigned integer defining the number of 'units' per second that should be allocated to the associated input. 'Units' are
	 * identified by the AllocationUnits property.
	 * 
	 * @param long new bandwidthAllocation property value
	 * @exception Exception
	 */
	public void setBandwidthAllocation(long bandwidthAllocation) {

		this.bandwidthAllocation = bandwidthAllocation;
	} // setBandwidthAllocation

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property burstAllocation.
	 */
	private long	burstAllocation;

	/**
	 * This method returns the AllocationSchedulingElement.burstAllocation property value. This property is described as follows:
	 * 
	 * A 32-bit bit unsigned integer specifying the amount of temporary or short-term bandwidth (in 'units' per second) that can be allocated to an
	 * input, beyond the amount of bandwidth allocated through the BandwidthAllocation property. If the maximum actual bandwidth allocation for the
	 * input were to be measured, it would be the sum of the BurstAllocation and the BandwidthAllocation properties. 'Units' are identified by the
	 * AllocationUnits property.
	 * 
	 * @return long current burstAllocation property value
	 * @exception Exception
	 */
	public long getBurstAllocation() {

		return this.burstAllocation;
	} // getBurstAllocation

	/**
	 * This method sets the AllocationSchedulingElement.burstAllocation property value. This property is described as follows:
	 * 
	 * A 32-bit bit unsigned integer specifying the amount of temporary or short-term bandwidth (in 'units' per second) that can be allocated to an
	 * input, beyond the amount of bandwidth allocated through the BandwidthAllocation property. If the maximum actual bandwidth allocation for the
	 * input were to be measured, it would be the sum of the BurstAllocation and the BandwidthAllocation properties. 'Units' are identified by the
	 * AllocationUnits property.
	 * 
	 * @param long new burstAllocation property value
	 * @exception Exception
	 */
	public void setBurstAllocation(long burstAllocation) {

		this.burstAllocation = burstAllocation;
	} // setBurstAllocation

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property canShare.
	 */
	private boolean	canShare;

	/**
	 * This method returns the AllocationSchedulingElement.canShare property value. This property is described as follows:
	 * 
	 * A boolean property that, if TRUE, enables unused bandwidth from the associated input to be allocated to other inputs serviced by the Scheduler.
	 * 
	 * @return boolean current canShare property value
	 * @exception Exception
	 */
	public boolean isCanShare() {

		return this.canShare;
	} // getCanShare

	/**
	 * This method sets the AllocationSchedulingElement.canShare property value. This property is described as follows:
	 * 
	 * A boolean property that, if TRUE, enables unused bandwidth from the associated input to be allocated to other inputs serviced by the Scheduler.
	 * 
	 * @param boolean new canShare property value
	 * @exception Exception
	 */
	public void setCanShare(boolean canShare) {

		this.canShare = canShare;
	} // setCanShare

	/**
	 * The following constants are defined for use with the ValueMap/Values qualified property workFlexible.
	 */
	private boolean	workFlexible;

	/**
	 * This method returns the AllocationSchedulingElement.workFlexible property value. This property is described as follows:
	 * 
	 * A boolean property that, if TRUE, indicates that the behavior of the scheduler relative to this input can be altered by changing the value of
	 * the inherited property, WorkConserving.
	 * 
	 * @return boolean current workFlexible property value
	 * @exception Exception
	 */
	public boolean isWorkFlexible() {

		return this.workFlexible;
	} // getWorkFlexible

	/**
	 * This method sets the AllocationSchedulingElement.workFlexible property value. This property is described as follows:
	 * 
	 * A boolean property that, if TRUE, indicates that the behavior of the scheduler relative to this input can be altered by changing the value of
	 * the inherited property, WorkConserving.
	 * 
	 * @param boolean new workFlexible property value
	 * @exception Exception
	 */
	public void setWorkFlexible(boolean workFlexible) {

		this.workFlexible = workFlexible;
	} // setWorkFlexible

} // Class AllocationSchedulingElement