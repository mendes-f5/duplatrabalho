$senha = Read-Host "Informe a senha do MySQL para o usuário root" -AsSecureString
$ponteiro = [Runtime.InteropServices.Marshal]::SecureStringToBSTR($senha)
$textoSenha = [Runtime.InteropServices.Marshal]::PtrToStringBSTR($ponteiro)
$env:MYSQL_PWD = $textoSenha
$env:DUPLATRABALHO_DB_SENHA = $textoSenha

$raiz = Split-Path -Parent $MyInvocation.MyCommand.Path
$mysql = "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe"
$driver = Join-Path $raiz "lib\mysql-connector-j-9.6.0.jar"
$saida = Join-Path $raiz "out"

& $mysql -u root -e "source $raiz\sql\schema.sql"
if ($LASTEXITCODE -ne 0) { throw "Não foi possível criar o banco de dados." }

New-Item -ItemType Directory -Path $saida -Force | Out-Null
$arquivos = Get-ChildItem -Path (Join-Path $raiz "src") -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -d $saida $arquivos
if ($LASTEXITCODE -ne 0) { throw "A compilação não foi concluída." }

java -cp "$saida;$driver" br.com.duplatrabalho.Main
