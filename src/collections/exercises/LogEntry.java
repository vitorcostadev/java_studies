package src.collections.exercises;

import org.jetbrains.annotations.NotNull;
import src.collections.domain.Severity;

import java.time.Instant;
import java.time.temporal.ChronoField;

/*
Crie uma classe LogEntry e um processador de logs que satisfaça os seguintes requisitos:
Imutabilidade: LogEntry deve ser imutável (use final ou record).
Campos: String serviceId, String message, Instant timestamp, enum Severity (INFO, WARN, ERROR).
Identidade Personalizada: Para fins de deduplicação, dois logs são iguais se tiverem o mesmo serviceId,
message e estiverem dentro de uma janela de tempo de 100ms um do outro (fuzzy equality).

Atenção: Isso desafia a propriedade transitiva do equals. Resolva ou documente a limitação.
Processamento:Receba uma List<LogEntry> bruta (milhões de entradas).
Elimine duplicatas de forma eficiente O(1) esperado).
Retorne um relatório ordenado: Primeiro por Severity (ERROR > WARN > INFO), depois cronologicamente.

Requisitos Técnicos:Implemente hashCode() e equals() manualmente (não use geração automática da IDE sem revisar) para garantir a consistência.
Use HashSet para a fase de deduplicação.Use TreeSet (com um Comparator customizado) para a fase de ordenação final.

Rigor Acadêmico:Explique (nos comentários do código) por que a complexidade de tempo global da sua solução é melhor do que usar apenas uma ArrayList e Collections.sort.
 */
public final class LogEntry implements Comparable<LogEntry> {
    private String serviceId;
    private String message;
    private Instant timestamp;
    private Severity severity;

    public LogEntry(String serviceId, String message, Instant timestamp, Severity severity) {
        this.serviceId = serviceId;
        this.message = message;
        this.timestamp = timestamp;
        this.severity = severity;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        LogEntry logEntry = (LogEntry) object;

        long aLong = this.timestamp.getLong(ChronoField.MILLI_OF_SECOND);
        long bLong = logEntry.getTimestamp().getLong(ChronoField.MILLI_OF_SECOND);

        return (logEntry.getServiceId().equals(this.serviceId) &&
                logEntry.getMessage().equals(this.message) &&
                (-100 <= (aLong - bLong) && (aLong - bLong) <= 100));
    }

    @Override
    public int hashCode() {
        return (this.serviceId != null &&
                this.timestamp != null &&
                (this.message != null && !this.message.isEmpty()) ? this.serviceId.hashCode() : 0);
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "serviceId='" + serviceId + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp.getLong(ChronoField.MILLI_OF_SECOND) +"ms" +
                ", severity=" + severity +
                '}';
    }

    @Override
    public int compareTo(@NotNull LogEntry o) {
        return this.serviceId.compareTo(o.getServiceId());
    }
}
