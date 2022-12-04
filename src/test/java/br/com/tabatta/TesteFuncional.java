package br.com.tabatta;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TesteFuncional {
    //Teste Funcional seria um teste sob a visao do usuário

    public WebDriver acessarAplicacao() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8001/tasks");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void deveSalvarTarefaComSucesso() {
        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            //Escrever descricao
            driver.findElement(By.id("task")).sendKeys("Teste Automacao");
            driver.findElement(By.id("dueDate")).sendKeys("04/12/2022");
            //Clicar em salvar
            driver.findElement(By.id("saveButton")).click();
            //Validar mensagem de sucesso
            WebElement btnSalvar = driver.findElement(By.id("message"));
            Assert.assertEquals("Erro Funcional - Mensagem de sucesso ao salvar nao foi mostrada corretamente ", "Sucess!", btnSalvar.getText());
        } finally {
            driver.quit();
        }
    }

    @Test
    public void naoSalvarTarefaComSucesso() {
        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            //Escrever descricao
            driver.findElement(By.id("task")).sendKeys("Teste Erro Automacao");
            driver.findElement(By.id("dueDate")).sendKeys("04/12/2010");
            //Clicar em salvar
            driver.findElement(By.id("saveButton")).click();
            //Validar mensagem de sucesso
            WebElement btnSalvar = driver.findElement(By.id("message"));
            Assert.assertEquals("Erro Funcional - Mensagem de erro ao salvar nao foi mostrada corretamente ", "Due date must not be in past", btnSalvar.getText());
        } finally {
            driver.quit();
        }
    }
    @Test
    public void naoSalvarTarefaSemDescricao() {
        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            //Escrever descricao
            driver.findElement(By.id("dueDate")).sendKeys("04/12/2022");
            //Clicar em salvar
            driver.findElement(By.id("saveButton")).click();
            //Validar mensagem de sucesso
            WebElement btnSalvar = driver.findElement(By.id("message"));
            Assert.assertEquals("Erro Funcional - Mensagem de erro ao salvar nao foi mostrada corretamente ", "Fill the task description", btnSalvar.getText());
        } finally {
            driver.quit();
        }
    }
    @Test
    public void naoDeveSalvarTarefaSemData() {
        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            //Escrever descricao
            driver.findElement(By.id("task")).sendKeys("Teste Erro Automacao");
            //Clicar em salvar
            driver.findElement(By.id("saveButton")).click();
            //Validar mensagem de sucesso
            WebElement btnSalvar = driver.findElement(By.id("message"));
            Assert.assertEquals("Erro Funcional - Mensagem de erro ao salvar nao foi mostrada corretamente ", "Fill the due date", btnSalvar.getText());
        } finally {
            driver.quit();
        }
    }
    @Test
    public void naoDeveSalvarTarefaComDataPassada() {
        WebDriver driver = acessarAplicacao();
        try {
            driver.findElement(By.id("addTodo")).click();
            //Escrever descricao
            driver.findElement(By.id("task")).sendKeys("Teste Erro Automacao");
            driver.findElement(By.id("dueDate")).sendKeys("04/12/2010");
            //Clicar em salvar
            driver.findElement(By.id("saveButton")).click();
            //Validar mensagem de sucesso
            WebElement btnSalvar = driver.findElement(By.id("message"));
            Assert.assertEquals("Erro Funcional - Mensagem de erro ao salvar nao foi mostrada corretamente ", "Due date must not be in past", btnSalvar.getText());
        } finally {
            driver.quit();
        }
    }
}
