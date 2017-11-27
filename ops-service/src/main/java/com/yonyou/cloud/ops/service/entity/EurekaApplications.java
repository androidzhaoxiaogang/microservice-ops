package com.yonyou.cloud.ops.service.entity;

import java.util.Arrays;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EurekaApplications {
	
	@JsonProperty("applications")
	private Applications applications;

	@JsonIgnoreProperties(ignoreUnknown = true)
	static class Applications{
		@JsonProperty("versions__delta")
		private String versions;
		
		@JsonProperty("apps__hashcode")
		private String appHashCode;
		
		@JsonProperty("application")
		private Application[] application;
		
		
		@JsonIgnoreProperties(ignoreUnknown = true)
		static class Application{
			
			private String name;
			
			private Instance[] Instance;
			
			@JsonIgnoreProperties(ignoreUnknown = true)
			static class Instance{
				
				private String instanceId;
				
				private String hostName;
				
				private String app;
				
				private String ipAddr;
				
				private String status;
				
				private String overriddenstatus;
				
				private Port port;
				
				private SecurePort securePort;
				
				private Long countryId;
				
				private LeaseInfo leaseInfo;
				
				private String homePageUrl;
				
				private String statusPageUrl;
				
				private String healthCheckUrl;
				
				private String vipAddress;
				
				private String secureVipAddress;
				
				private String isCoordinatingDiscoveryServer;
				
				private String lastUpdatedTimestamp;
				
				private String lastDirtyTimestamp;
				
				private String actionType;
				
				private Map<String, Object> metadata;
				
				@JsonIgnoreProperties(ignoreUnknown = true)
				static  class  Port{
					
					@JsonProperty("$")
					private Long port;
					
					@JsonProperty("@enabled")
					private String enabled;
					
					public Long getPort() {
						return port;
					}

					public void setPort(Long port) {
						this.port = port;
					}

					public String getEnabled() {
						return enabled;
					}

					public void setEnabled(String enabled) {
						this.enabled = enabled;
					}

					@Override
					public String toString() {
						return "Port [port=" + port + ", enabled=" + enabled + "]";
					}
				}
				
				@JsonIgnoreProperties(ignoreUnknown = true)
				static class SecurePort{
					@JsonProperty("$")
					private Long port;
					
					@JsonProperty("@enabled")
					private String enabled;

					public Long getPort() {
						return port;
					}

					public void setPort(Long port) {
						this.port = port;
					}

					public String getEnabled() {
						return enabled;
					}

					public void setEnabled(String enabled) {
						this.enabled = enabled;
					}

					@Override
					public String toString() {
						return "SecurePort [port=" + port + ", enabled=" + enabled + "]";
					}
					
				}
				
				@JsonIgnoreProperties(ignoreUnknown = true)
				static class LeaseInfo{
					private Long renewalIntervalInSecs;
					
					private Long durationInSecs;
					
					private Long registrationTimestamp;
					
					private Long lastRenewalTimestamp;
					
					private Long evictionTimestamp;
					
					private Long serviceUpTimestamp;

					public Long getRenewalIntervalInSecs() {
						return renewalIntervalInSecs;
					}

					public void setRenewalIntervalInSecs(Long renewalIntervalInSecs) {
						this.renewalIntervalInSecs = renewalIntervalInSecs;
					}

					public Long getDurationInSecs() {
						return durationInSecs;
					}

					public void setDurationInSecs(Long durationInSecs) {
						this.durationInSecs = durationInSecs;
					}

					public Long getRegistrationTimestamp() {
						return registrationTimestamp;
					}

					public void setRegistrationTimestamp(Long registrationTimestamp) {
						this.registrationTimestamp = registrationTimestamp;
					}

					public Long getLastRenewalTimestamp() {
						return lastRenewalTimestamp;
					}

					public void setLastRenewalTimestamp(Long lastRenewalTimestamp) {
						this.lastRenewalTimestamp = lastRenewalTimestamp;
					}

					public Long getEvictionTimestamp() {
						return evictionTimestamp;
					}

					public void setEvictionTimestamp(Long evictionTimestamp) {
						this.evictionTimestamp = evictionTimestamp;
					}

					public Long getServiceUpTimestamp() {
						return serviceUpTimestamp;
					}

					public void setServiceUpTimestamp(Long serviceUpTimestamp) {
						this.serviceUpTimestamp = serviceUpTimestamp;
					}

					@Override
					public String toString() {
						return "LeaseInfo [renewalIntervalInSecs=" + renewalIntervalInSecs + ", durationInSecs="
								+ durationInSecs + ", registrationTimestamp=" + registrationTimestamp
								+ ", lastRenewalTimestamp=" + lastRenewalTimestamp + ", evictionTimestamp="
								+ evictionTimestamp + ", serviceUpTimestamp=" + serviceUpTimestamp + "]";
					}
				}
				

				public String getInstanceId() {
					return instanceId;
				}

				public void setInstanceId(String instanceId) {
					this.instanceId = instanceId;
				}

				public String getHostName() {
					return hostName;
				}

				public void setHostName(String hostName) {
					this.hostName = hostName;
				}

				public String getApp() {
					return app;
				}

				public void setApp(String app) {
					this.app = app;
				}

				public String getIpAddr() {
					return ipAddr;
				}

				public void setIpAddr(String ipAddr) {
					this.ipAddr = ipAddr;
				}

				public String getStatus() {
					return status;
				}

				public void setStatus(String status) {
					this.status = status;
				}

				public String getOverriddenstatus() {
					return overriddenstatus;
				}

				public void setOverriddenstatus(String overriddenstatus) {
					this.overriddenstatus = overriddenstatus;
				}

				public Port getPort() {
					return port;
				}

				public void setPort(Port port) {
					this.port = port;
				}

				public SecurePort getSecurePort() {
					return securePort;
				}

				public void setSecurePort(SecurePort securePort) {
					this.securePort = securePort;
				}

				public Long getCountryId() {
					return countryId;
				}

				public void setCountryId(Long countryId) {
					this.countryId = countryId;
				}

				public LeaseInfo getLeaseInfo() {
					return leaseInfo;
				}

				public void setLeaseInfo(LeaseInfo leaseInfo) {
					this.leaseInfo = leaseInfo;
				}

				public String getHomePageUrl() {
					return homePageUrl;
				}

				public void setHomePageUrl(String homePageUrl) {
					this.homePageUrl = homePageUrl;
				}

				public String getStatusPageUrl() {
					return statusPageUrl;
				}

				public void setStatusPageUrl(String statusPageUrl) {
					this.statusPageUrl = statusPageUrl;
				}

				public String getHealthCheckUrl() {
					return healthCheckUrl;
				}

				public void setHealthCheckUrl(String healthCheckUrl) {
					this.healthCheckUrl = healthCheckUrl;
				}

				public String getVipAddress() {
					return vipAddress;
				}

				public void setVipAddress(String vipAddress) {
					this.vipAddress = vipAddress;
				}

				public String getSecureVipAddress() {
					return secureVipAddress;
				}

				public void setSecureVipAddress(String secureVipAddress) {
					this.secureVipAddress = secureVipAddress;
				}

				public String getIsCoordinatingDiscoveryServer() {
					return isCoordinatingDiscoveryServer;
				}

				public void setIsCoordinatingDiscoveryServer(String isCoordinatingDiscoveryServer) {
					this.isCoordinatingDiscoveryServer = isCoordinatingDiscoveryServer;
				}

				public String getLastUpdatedTimestamp() {
					return lastUpdatedTimestamp;
				}

				public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) {
					this.lastUpdatedTimestamp = lastUpdatedTimestamp;
				}

				public String getLastDirtyTimestamp() {
					return lastDirtyTimestamp;
				}

				public void setLastDirtyTimestamp(String lastDirtyTimestamp) {
					this.lastDirtyTimestamp = lastDirtyTimestamp;
				}

				public String getActionType() {
					return actionType;
				}

				public void setActionType(String actionType) {
					this.actionType = actionType;
				}
				
				public Map<String, Object> getMetadata() {
					return metadata;
				}

				public void setMetadata(Map<String, Object> metadata) {
					this.metadata = metadata;
				}

				@Override
				public String toString() {
					return "Instance [instanceId=" + instanceId + ", hostName=" + hostName + ", app=" + app
							+ ", ipAddr=" + ipAddr + ", status=" + status + ", overriddenstatus=" + overriddenstatus
							+ ", port=" + port + ", securePort=" + securePort + ", countryId=" + countryId
							+ ", leaseInfo=" + leaseInfo + ", homePageUrl=" + homePageUrl + ", statusPageUrl="
							+ statusPageUrl + ", healthCheckUrl=" + healthCheckUrl + ", vipAddress=" + vipAddress
							+ ", secureVipAddress=" + secureVipAddress + ", isCoordinatingDiscoveryServer="
							+ isCoordinatingDiscoveryServer + ", lastUpdatedTimestamp=" + lastUpdatedTimestamp
							+ ", lastDirtyTimestamp=" + lastDirtyTimestamp + ", actionType=" + actionType
							+ ", metadata=" + metadata + "]";
				}

				
				
			}


			public String getName() {
				return name;
			}


			public void setName(String name) {
				this.name = name;
			}


			public Instance[] getInstance() {
				return Instance;
			}


			public void setInstance(Instance[] instance) {
				Instance = instance;
			}


			@Override
			public String toString() {
				return "Application [name=" + name + ", Instance=" + Arrays.toString(Instance) + "]";
			}
			
		}
		
		public String getVersions() {
			return versions;
		}

		public void setVersions(String versions) {
			this.versions = versions;
		}

		public String getAppHashCode() {
			return appHashCode;
		}

		public void setAppHashCode(String appHashCode) {
			this.appHashCode = appHashCode;
		}

		public Application[] getApplication() {
			return application;
		}

		public void setApplication(Application[] application) {
			this.application = application;
		}

		@Override
		public String toString() {
			return "Applications [versions=" + versions + ", appHashCode=" + appHashCode + ", application="
					+ Arrays.toString(application) + "]";
		}
	}

	public Applications getApplications() {
		return applications;
	}
	
	public void setApplications(Applications applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "EurekaApplications [applications=" + applications+ "]";
	}
	
	
	

}
