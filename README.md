## Sample SpringBOOT Application on K8s Cluster

###Set up
#### Required Installations
```
brew install minikube 
```
```
brew install helm 
```
```
brew install kubectl 
```
#### Configure MiniKube
```aidl
minikube start --driver=docker
```
```
minikube status
```
```
minikube docker-env
```
```
eval $(minikube -p minikube docker-env)
```

#### Deploy ConfigMap and Secrets
```aidl
kubectl create configmap kcluster-config-map --from-env-file=k8/config.properties
```
```
kubectl describe configmaps kcluster-config-map
```
```
kubectl get configmaps kcluster-config-map -o yaml > k8/config-map.yml
```
```
kubectl apply -f k8/secrets.yml
```

#### Deploy MySQL
```aidl
kubectl apply -f k8/mysql-pv.yml
```
```
kubectl apply -f k8/mysql-pvc.yml
```
```
kubectl apply -f k8/mysql.yml
```

#### Build Customer Service
```aidl
mvn clean package
```
```
docker build -t kcluster-customer:1.0 .
```

#### Deploy Customer Service

```aidl
❯ kaf k8/customer-service-deployment.yml 
```
#### List K8s Components
```aidl
kubectl get deployments
```
```
NAME                READY   UP-TO-DATE   AVAILABLE   AGE
kcluster-customer   2/2     2            2           11m
mysql               1/1     1            1           19m
```
```aidl
kubectl get services
```
```
NAME                    TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
kcluster-customer-svc   NodePort    10.109.210.176   <none>        8080:30000/TCP   11m
kubernetes              ClusterIP   10.96.0.1        <none>        443/TCP          29m
mysql                   ClusterIP   None             <none>        3306/TCP         20m
```
Second port listed for kcluster-customer-svc can be used to connect to the service from ourside the cluster. 
For host/ip use command following command.

❯ minikube ip
```aidl
kubectl get pods
```
```
NAME                                READY   STATUS    RESTARTS   AGE
kcluster-customer-9484df7fb-lctkn   1/1     Running   0          13m
kcluster-customer-9484df7fb-rh69g   1/1     Running   0          13m
mysql-849489bd49-hhvrj              1/1     Running   0          21m
```
#### Check Logs
```aidl
kubectl logs kcluster-customer-9484df7fb-lctkn
```

#### Access Pod Terminal
```aidl
kubectl exec -it kcluster-customer-9484df7fb-lctkn /bin/bash
```
#### Launch K8s Dashboard
```aidl
minikube dashboard
```













