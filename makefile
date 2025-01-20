MIGRATION_DIR := src/main/resources/db/migration

migration:
	@if [ -z "$(name)" ]; then \
		echo "Error: Migration name is required. Usage: make migration name=<migration_name>"; \
		exit 1; \
	fi; \
	cd $(MIGRATION_DIR) && \
	next_version=$$(if [ -z "$$(ls V*__*.sql 2>/dev/null)" ]; then \
		echo "01"; \
	else \
		ls V*__*.sql | grep -o '^V[0-9]\+' | grep -o '[0-9]\+' | sort -n | tail -1 | awk '{printf "%02d", $$1 + 1}'; \
	fi); \
	filename="V$${next_version}__$(name).sql"; \
	touch $$filename; \
	echo "Created migration file: $$filename"

commit:
	git diff | cody chat --stdin -m 'Write a conventional commit message for this diff'