import http.client

username = "guillermo"
password = "123456"

ip = "192.168.56.104"
puerto = "8080"

headers = {"Content-Type": "application/x-www-form-urlencoded"}
data = "username=" + username + "&password=" + password  # Corrección aquí
conn = http.client.HTTPConnection(ip, puerto)
conn.request("POST", "/login", body=data, headers=headers)
response = conn.getresponse()

if response.status == 200:  # Corrección aquí
    print("Inicio de sesión exitoso")
else:
    print("Error en inicio de sesión:", response.reason)

conn.close()
